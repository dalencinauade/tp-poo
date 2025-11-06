package alquilervehiculos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import alquilervehiculos.model.dto.ClienteObtenerDatosInterfazDTO;
import alquilervehiculos.model.entities.Cliente;
import alquilervehiculos.model.enums.EstadoAlquilerEnum;
import alquilervehiculos.model.enums.EstadoReservaEnum;

public class ClienteDAO {
    
    public boolean registrar(Connection connection, Cliente cliente) throws SQLException {
        String query = "INSERT INTO clientes (idCliente, numeroLicencia, fechaVencimientoLicencia) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cliente.getIdCliente());
            statement.setString(2, cliente.getNumeroLicencia());
            statement.setString(3, cliente.getFechaVencimientoLicenciaString());

            int filas = statement.executeUpdate();
            
            return filas > 0;
        }
    }

    public boolean editar(Connection connection, Cliente cliente) throws SQLException {
        String query = "UPDATE clientes SET numeroLicencia = ?, fechaVencimientoLicencia = ? WHERE idCliente = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cliente.getNumeroLicencia());
            statement.setString(2, cliente.getFechaVencimientoLicenciaString());
            statement.setInt(3, cliente.getIdCliente());

            int filas = statement.executeUpdate();
            
            return filas > 0;
        }
    }

    public ClienteObtenerDatosInterfazDTO obtenerDatosInterfaz(int idUsuario) throws SQLException {
        ClienteObtenerDatosInterfazDTO dto = new ClienteObtenerDatosInterfazDTO();
        Connection connection = ConexionSQLite.getConnection();

        String query = "SELECT estadoId FROM reservas WHERE idCliente = ? AND idEstado = ? LIMIT 1";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idUsuario);
            statement.setInt(2, EstadoReservaEnum.PENDIENTE.getId());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                dto.setEstadoReserva(EstadoReservaEnum.fromId(resultSet.getInt("idEstado")));
            }
        }

        query = "SELECT estadoId FROM alquileres WHERE idCliente = ? AND idEstado = ? LIMIT 1";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idUsuario);
            statement.setInt(2, EstadoAlquilerEnum.VIGENTE.getId());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                dto.setEstadoAlquiler(EstadoAlquilerEnum.fromId(resultSet.getInt("idEstado")));
            }
        }

        return dto;
    }
}
