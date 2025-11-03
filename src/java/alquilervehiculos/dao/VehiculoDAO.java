package alquilervehiculos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import alquilervehiculos.model.entities.Vehiculo;

public class VehiculoDAO {

    public boolean guardar(Connection connection, Vehiculo vehiculo) throws SQLException {
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
}
