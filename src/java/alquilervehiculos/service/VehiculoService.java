package alquilervehiculos.service;

import java.sql.Connection;
import java.util.List;

import alquilervehiculos.dao.ConexionSQLite;
import alquilervehiculos.dao.VehiculoDAO;
import alquilervehiculos.model.dto.ListarVehiculosDTO;
import alquilervehiculos.model.dto.ObtenerVehiculoParaEdicionDTO;
import alquilervehiculos.model.entities.Vehiculo;

public class VehiculoService {
    private final VehiculoDAO vehiculoDAO;
    
    public VehiculoService(VehiculoDAO vehiculoDAO) {
        this.vehiculoDAO = vehiculoDAO;
    }

    public boolean crear(Vehiculo vehiculo) throws Exception {
        Connection connection = null;

        try {
            connection = ConexionSQLite.getConnection();
            connection.setAutoCommit(false);

            boolean exito = vehiculoDAO.crear(connection, vehiculo);

            if (!exito) {
                throw new Exception("No se pudo crear el vehículo");
            }

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }

        return true;
    }

    public List<ListarVehiculosDTO> listarVehiculos() throws Exception {
        return vehiculoDAO.listarVehiculos();
    }

    public ObtenerVehiculoParaEdicionDTO obtenerParaEdicion(int idVehiculo) throws Exception {
        return vehiculoDAO.obtenerParaEdicion(idVehiculo);
    }

    public boolean editar(Vehiculo vehiculo) throws Exception {
        Connection connection = null;

        try {
            connection = ConexionSQLite.getConnection();
            connection.setAutoCommit(false);

            boolean exito = vehiculoDAO.editar(connection, vehiculo);

            if (!exito) {
                throw new Exception("No se pudo editar el vehículo");
            }

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }

        return true;
    }
}
