package alquilervehiculos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import alquilervehiculos.model.entities.Empleado;

public class EmpleadoDAO {
    
    public boolean registrar(Connection connection, Empleado empleado) throws SQLException {
        String query = "INSERT INTO empleados (idEmpleado, legajo, salario) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, empleado.getIdEmpleado());
            statement.setString(2, empleado.getLegajo());
            statement.setDouble(3, empleado.getSalario());

            int filas = statement.executeUpdate();
            
            return filas > 0;
        }
    }
}
