package alquilervehiculos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import alquilervehiculos.model.entities.Persona;

public class PersonaDAO {
    
    public boolean registrar(Connection connection, Persona persona) throws SQLException {
        String query = "INSERT INTO personas (idPersona, nombre, apellido, email, dni, telefono, direccion, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, persona.getIdPersona());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellido());
            statement.setString(4, persona.getEmail());
            statement.setString(5, persona.getDni());
            statement.setString(6, persona.getTelefono());
            statement.setString(7, persona.getDireccion());
            statement.setString(8, persona.getFechaNacimientoString());

            int filas = statement.executeUpdate();
            
            return filas > 0;
        }
    }

    public boolean editar(Connection connection, Persona persona) throws SQLException {
        String query = "UPDATE personas SET nombre = ?, apellido = ?, email = ?, dni = ?, telefono = ?, direccion = ?, fechaNacimiento = ? WHERE idPersona = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellido());
            statement.setString(3, persona.getEmail());
            statement.setString(4, persona.getDni());
            statement.setString(5, persona.getTelefono());
            statement.setString(6, persona.getDireccion());
            statement.setString(7, persona.getFechaNacimientoString());
            statement.setInt(8, persona.getIdPersona());

            int filas = statement.executeUpdate();
            
            return filas > 0;
        }
    }
}
