package alquilervehiculos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import alquilervehiculos.model.entities.Tecnico;

public class TecnicoDAO {
    
    public boolean registrar(Connection connection, Tecnico tecnico) throws SQLException {
        String query = "INSERT INTO tecnicos (idTecnico, cantidadRevisiones) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, tecnico.getIdTecnico());
            statement.setInt(2, tecnico.getCantidadRevisiones());

            int filas = statement.executeUpdate();

            return filas > 0;
        }
    }
}