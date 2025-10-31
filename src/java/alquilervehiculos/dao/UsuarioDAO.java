package alquilervehiculos.dao;

import alquilervehiculos.model.entities.Sesion;
import alquilervehiculos.model.enums.RolUsuarioEnum;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsuarioDAO {

    public Sesion login(String email, String password) throws SQLException {
        Connection connection = ConexionSQLite.getConnection();
        String query = "SELECT id, email, idRol FROM usuarios WHERE email = ? AND password = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, hashPassword(password));

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Sesion(
                    resultSet.getInt("id"),
                    resultSet.getString("email"),
                    RolUsuarioEnum.fromId(resultSet.getInt("idRol"))
                );
            } else {
                return null; // No se encontró al usuario
            }
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte [] hash = digest.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                
                if (hex.length() == 1) {
                    hexString.append('0');
                }

                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
