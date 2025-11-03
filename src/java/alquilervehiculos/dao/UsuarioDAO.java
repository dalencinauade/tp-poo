package alquilervehiculos.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import alquilervehiculos.model.dto.ListarUsuariosDTO;
import alquilervehiculos.model.dto.ObtenerUsuarioParaEdicionDTO;
import alquilervehiculos.model.entities.Sesion;
import alquilervehiculos.model.entities.Usuario;
import alquilervehiculos.model.enums.RolUsuarioEnum;

public class UsuarioDAO {

    public Sesion login(String username, String password) throws SQLException {
        Connection connection = ConexionSQLite.getConnection();
        
        String query = """
            SELECT idUsuario, username, nombre, idRol FROM usuarios
            INNER JOIN personas ON idUsuario = idPersona
            WHERE username = ? AND password = ?
        """;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, hashPassword(password));

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Sesion(
                    resultSet.getInt("idUsuario"),
                    resultSet.getString("username"),
                    resultSet.getString("nombre"),
                    RolUsuarioEnum.fromId(resultSet.getInt("idRol"))
                );
            }
        }

        return null; // No se encontró el usuario
    }

    public int registrar(Connection connection, Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuarios (username, password, idRol, fechaCreacion) VALUES (?, ?, ?, ?)";
        int id = 0;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usuario.getUsername());
            statement.setString(2, hashPassword(usuario.getPassword()));
            statement.setInt(3, usuario.getRol().getId());
            statement.setString(4, usuario.getFechaCreacionString());

            int filas = statement.executeUpdate();
            
            if (filas == 0) {
                throw new SQLException("No se pudo insertar el usuario. Ninguna fila afectada");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID del nuevo usuario.");
                }
            }
        }

        return id;
    }

    public List<ListarUsuariosDTO> listarUsuarios() throws SQLException {
        Connection connection = ConexionSQLite.getConnection();

        String query = """
            SELECT idUsuario, username, nombre, apellido, idRol
            FROM usuarios
            INNER JOIN personas p ON idPersona = idUsuario
            WHERE idRol != 1
        """;

        List<ListarUsuariosDTO> lista = new ArrayList<>();
        
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ListarUsuariosDTO dto = new ListarUsuariosDTO(
                    rs.getInt("idUsuario"),
                    rs.getString("username"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    RolUsuarioEnum.fromId(rs.getInt("idRol")).toString()
                );

                lista.add(dto);
            }
        }

        return lista;
    }

    public ObtenerUsuarioParaEdicionDTO obtenerParaEdicion(int idUsuario) throws SQLException {
        Connection connection = ConexionSQLite.getConnection();

        String query = """
            SELECT nombre, apellido, email, dni, telefono, direccion, fechaNacimiento, legajo, salario,
            metaAlquileresMensual, idiomas, bonoRendimiento, fechaInicioComoGerente, metaVentasMensual,
            numeroLicencia, fechaVencimientoLicencia, idRol
            FROM usuarios
            LEFT JOIN personas on idPersona = idUsuario
            LEFT JOIN empleados on idEmpleado = idUsuario
            LEFT JOIN administrativos on idAdministrativo = idUsuario
            LEFT JOIN gerentes on idGerente = idUsuario
            LEFT JOIN clientes on idCliente = idUsuario
            WHERE idUsuario = ?
        """;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ObtenerUsuarioParaEdicionDTO dto = new ObtenerUsuarioParaEdicionDTO();
                    dto.setNombre(rs.getString("nombre"));
                    dto.setApellido(rs.getString("apellido"));
                    dto.setEmail(rs.getString("email"));
                    dto.setDni(rs.getString("dni"));
                    dto.setTelefono(rs.getString("telefono"));
                    dto.setDireccion(rs.getString("direccion"));
                    dto.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    dto.setLegajo(rs.getString("legajo"));
                    dto.setSalario(rs.getDouble("salario"));
                    dto.setMetaAlquileresMensual(rs.getInt("metaAlquileresMensual"));
                    dto.setIdiomas(rs.getString("idiomas"));
                    dto.setBonoRendimiento(rs.getDouble("bonoRendimiento"));
                    dto.setFechaInicioComoGerente(rs.getDate("fechaInicioComoGerente"));
                    dto.setMetaVentasMensual(rs.getDouble("metaVentasMensual"));
                    dto.setNumeroLicencia(rs.getString("numeroLicencia"));
                    dto.setFechaVencimientoLicencia(rs.getDate("fechaVencimientoLicencia"));
                    dto.setRol(RolUsuarioEnum.fromId(rs.getInt("idRol")).toString());

                    return dto;
                }
            }
        }

        return null; // No se encontró el usuario
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte [] hash = digest.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                
                if (hex.length() == 1) {
                    hexString.append('0');
                }

                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
