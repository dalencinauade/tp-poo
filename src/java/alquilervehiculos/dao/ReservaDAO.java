package alquilervehiculos.dao;

import java.sql.*;
import java.text.SimpleDateFormat;

import alquilervehiculos.model.entities.Reserva;
import alquilervehiculos.model.enums.EstadoReservaEnum;

public class ReservaDAO {

    public boolean crear(Connection connection, int idVehiculo, int idUsuario, Reserva reserva) throws SQLException {
        String query = "INSERT INTO reservas (idCliente, idVehiculo, fechaReserva, fechaInicio, fechaFin, costoEstimado, idEstado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idUsuario);
            statement.setInt(2, idVehiculo);
            statement.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(reserva.getFechaReserva()));
            statement.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(reserva.getFechaInicio()));
            statement.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(reserva.getFechaFin()));
            statement.setDouble(6, reserva.getCostoEstimado());
            statement.setInt(7, EstadoReservaEnum.PENDIENTE.getId());

            int filas = statement.executeUpdate();

            return filas > 0;
        }
    }
}