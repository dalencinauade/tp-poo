package alquilervehiculos.dao;

import alquilervehiculos.model.entities.Sesion;
import alquilervehiculos.model.entities.Usuario;
import alquilervehiculos.model.enums.RolUsuarioEnum;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsuarioDAO {

    public Sesion login(String username, String password) throws SQLException {
        Connection connection = ConexionSQLite.getConnection();
        String query = "SELECT idUsuario, username, nombre, idRol FROM usuarios ";
        query += "INNER JOIN personas ON idUsuario = idPersona ";
        query += "WHERE username = ? AND password = ?";

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
                throw new SQLException("No se pudo insertar el usuario, ninguna fila afectada");
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
