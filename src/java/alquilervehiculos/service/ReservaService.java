package alquilervehiculos.service;

import java.sql.Connection;

import alquilervehiculos.dao.ConexionSQLite;
import alquilervehiculos.dao.ReservaDAO;
import alquilervehiculos.model.entities.Reserva;

public class ReservaService {
    private final ReservaDAO reservaDAO;

    public ReservaService(ReservaDAO reservaDAO) {
        this.reservaDAO = reservaDAO;
    }

    public boolean confirmar(int idVehiculo, int idUsuario, Reserva reserva) throws Exception {
        Connection connection = null;

        try {
            connection = ConexionSQLite.getConnection();
            connection.setAutoCommit(false);

            boolean exito = reservaDAO.crear(connection, idVehiculo, idUsuario, reserva);

            if (!exito) {
                throw new Exception("No se pudo crear la reserva");
            }

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }

        return true;
    }
}
