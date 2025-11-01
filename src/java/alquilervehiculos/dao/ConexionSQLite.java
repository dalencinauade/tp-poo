package alquilervehiculos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;

public class ConexionSQLite {
    private static Connection connection;
    private static final String connectionString = "src/resources/alquilervehiculos.db";


    private ConexionSQLite() {
        // Constructor privado para evitar instanciación (patrón Singleton)
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            File dbFile = new File(connectionString);

            if (!dbFile.exists()) {
                throw new SQLException("No se encontró la base de datos en: " + dbFile.getAbsolutePath());
            }

            String connectionString = "jdbc:sqlite:" + dbFile.getAbsolutePath();
            connection = DriverManager.getConnection(connectionString);
        }
        
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión a la base de datos. " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
