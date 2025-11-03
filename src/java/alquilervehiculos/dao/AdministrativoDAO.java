package alquilervehiculos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import alquilervehiculos.model.entities.Administrativo;

public class AdministrativoDAO {
    
    public boolean registrar(Connection connection, Administrativo administrativo) throws SQLException {
        String query = "INSERT INTO administrativos (idAdministrativo, metaAlquileresMensual, cantidadClientesAtendidos, idiomas) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, administrativo.getIdAdministrativo());
            statement.setDouble(2, administrativo.getMetaAlquileresMensual());
            statement.setInt(3, administrativo.getCantidadClientesAtendidos());
            statement.setString(4, administrativo.getIdiomas());

            int filas = statement.executeUpdate();

            return filas > 0;
        }
    }

    public boolean editar(Connection connection, Administrativo administrativo) throws SQLException {
        String query = "UPDATE administrativos SET metaAlquileresMensual = ?, idiomas = ? WHERE idAdministrativo = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, administrativo.getMetaAlquileresMensual());
            statement.setString(2, administrativo.getIdiomas());
            statement.setInt(3, administrativo.getIdAdministrativo());

            int filas = statement.executeUpdate();

            return filas > 0;
        }
    }
}
