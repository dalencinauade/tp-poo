package alquilervehiculos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import alquilervehiculos.model.entities.Gerente;

public class GerenteDAO {
    
    public boolean registrar(Connection connection, Gerente gerente) throws SQLException {
        String query = "INSERT INTO gerentes (idGerente, bonoRendimiento, fechaInicioComoGerente, metaVentasMensual) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, gerente.getIdGerente());
            statement.setDouble(2, gerente.getBonoRendimiento());
            statement.setString(3, gerente.getFechaInicioComoGerenteString());
            statement.setDouble(4, gerente.getMetaVentasMensual());

            int filas = statement.executeUpdate();

            return filas > 0;
        }
    }

    public boolean editar(Connection connection, Gerente gerente) throws SQLException {
        String query = "UPDATE gerentes SET bonoRendimiento = ?, fechaInicioComoGerente = ?, metaVentasMensual = ? WHERE idGerente = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, gerente.getBonoRendimiento());
            statement.setString(2, gerente.getFechaInicioComoGerenteString());
            statement.setDouble(3, gerente.getMetaVentasMensual());
            statement.setInt(4, gerente.getIdGerente());

            int filas = statement.executeUpdate();

            return filas > 0;
        }
    }
}