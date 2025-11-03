package alquilervehiculos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import alquilervehiculos.model.entities.Cliente;

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
}
