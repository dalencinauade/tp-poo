package alquilervehiculos.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import alquilervehiculos.model.dto.ListarVehiculosDTO;
import alquilervehiculos.model.dto.ObtenerVehiculoParaEdicionDTO;
import alquilervehiculos.model.entities.Vehiculo;
import alquilervehiculos.model.enums.CategoriaVehiculoEnum;
import alquilervehiculos.model.enums.EstadoVehiculoEnum;

public class VehiculoDAO {

    public boolean crear(Connection connection, Vehiculo vehiculo) throws SQLException {
        String query = "INSERT INTO vehiculos (patente, marca, modelo, anio, precioDiario, capacidadTanque, capacidadTanqueMaxima, kilometraje, idCategoria, idEstado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, vehiculo.getPatente());
            statement.setString(2, vehiculo.getMarca());
            statement.setString(3, vehiculo.getModelo());
            statement.setInt(4, vehiculo.getAnio());
            statement.setDouble(5, vehiculo.getPrecioDiario());
            statement.setDouble(6, vehiculo.getCapacidadTanque());
            statement.setDouble(7, vehiculo.getCapacidadTanqueMaxima());
            statement.setInt(8, vehiculo.getKilometraje());
            statement.setInt(9, vehiculo.getCategoria().getId());
            statement.setInt(10, vehiculo.getEstado().getId());

            int filas = statement.executeUpdate();
            
            return filas > 0;
        }
    }

    public List<ListarVehiculosDTO> listarVehiculos() throws SQLException {
        Connection connection = ConexionSQLite.getConnection();

        String query = """
            SELECT idVehiculo, patente, marca, modelo, anio, kilometraje, idCategoria, idEstado
            FROM vehiculos
        """;

        List<ListarVehiculosDTO> lista = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CategoriaVehiculoEnum categoria = CategoriaVehiculoEnum.fromId(rs.getInt("idCategoria"));
                EstadoVehiculoEnum estado = EstadoVehiculoEnum.fromId(rs.getInt("idEstado"));

                ListarVehiculosDTO dto = new ListarVehiculosDTO(
                    rs.getInt("idVehiculo"),
                    rs.getString("patente"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("anio"),
                    rs.getInt("kilometraje"),
                    CategoriaVehiculoEnum.toString(categoria),
                    EstadoVehiculoEnum.toString(estado)
                );

                lista.add(dto);
            }
        }

        return lista;
    }

    public ObtenerVehiculoParaEdicionDTO obtenerParaEdicion(int idVehiculo) throws SQLException {
        Connection connection = ConexionSQLite.getConnection();

        String query = """
            SELECT idVehiculo, patente, marca, modelo, anio, precioDiario, capacidadTanque, capacidadTanqueMaxima, kilometraje, idCategoria, idEstado
            FROM vehiculos
            WHERE idVehiculo = ?
        """;

        ObtenerVehiculoParaEdicionDTO dto = null;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idVehiculo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    CategoriaVehiculoEnum categoria = CategoriaVehiculoEnum.fromId(rs.getInt("idCategoria"));
                    EstadoVehiculoEnum estado = EstadoVehiculoEnum.fromId(rs.getInt("idEstado"));

                    dto = new ObtenerVehiculoParaEdicionDTO();
                    dto.setPatente(rs.getString("patente"));
                    dto.setMarca(rs.getString("marca"));
                    dto.setModelo(rs.getString("modelo"));
                    dto.setAnio(rs.getInt("anio"));
                    dto.setPrecioDiario(rs.getDouble("precioDiario"));
                    dto.setCapacidadTanque(rs.getDouble("capacidadTanque"));
                    dto.setCapacidadTanqueMaxima(rs.getDouble("capacidadTanqueMaxima"));
                    dto.setKilometraje(rs.getInt("kilometraje"));
                    dto.setCategoria(CategoriaVehiculoEnum.toString(categoria));
                    dto.setEstado(EstadoVehiculoEnum.toString(estado));
                }
            }
        }

        return dto;
    }

    public boolean editar(Connection connection, Vehiculo vehiculo) throws SQLException {
        String query = "UPDATE vehiculos SET patente = ?, marca = ?, modelo = ?, anio = ?, precioDiario = ?, capacidadTanque = ?, capacidadTanqueMaxima = ?, kilometraje = ?, idCategoria = ?, idEstado = ? WHERE idVehiculo = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, vehiculo.getPatente());
            statement.setString(2, vehiculo.getMarca());
            statement.setString(3, vehiculo.getModelo());
            statement.setInt(4, vehiculo.getAnio());
            statement.setDouble(5, vehiculo.getPrecioDiario());
            statement.setDouble(6, vehiculo.getCapacidadTanque());
            statement.setDouble(7, vehiculo.getCapacidadTanqueMaxima());
            statement.setInt(8, vehiculo.getKilometraje());
            statement.setInt(9, vehiculo.getCategoria().getId());
            statement.setInt(10, vehiculo.getEstado().getId());
            statement.setInt(11, vehiculo.getIdVehiculo());

            int filas = statement.executeUpdate();
            
            return filas > 0;
        }
    }
}
