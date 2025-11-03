package alquilervehiculos.service;

import java.sql.Connection;

import alquilervehiculos.dao.ConexionSQLite;
import alquilervehiculos.dao.VehiculoDAO;
import alquilervehiculos.model.entities.Vehiculo;

public class VehiculoService {
    private final VehiculoDAO vehiculoDAO;
    
    public VehiculoService(VehiculoDAO vehiculoDAO) {
        this.vehiculoDAO = vehiculoDAO;
    }

    public boolean guardar(Vehiculo vehiculo) throws Exception {
        Connection connection = null;

        try {
            connection = ConexionSQLite.getConnection();
            connection.setAutoCommit(false);

            boolean exito = vehiculoDAO.guardar(connection, vehiculo);

            if (!exito) {
                throw new Exception("No se pudo guardar el vehículo");
            }

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }

        return true;
    }
}
