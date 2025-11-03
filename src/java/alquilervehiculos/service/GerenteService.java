package alquilervehiculos.service;

import java.sql.Connection;

import alquilervehiculos.dao.ConexionSQLite;
import alquilervehiculos.dao.EmpleadoDAO;
import alquilervehiculos.dao.GerenteDAO;
import alquilervehiculos.dao.PersonaDAO;
import alquilervehiculos.dao.UsuarioDAO;
import alquilervehiculos.model.entities.Empleado;
import alquilervehiculos.model.entities.Gerente;
import alquilervehiculos.model.entities.Persona;
import alquilervehiculos.model.entities.Usuario;

public class GerenteService {
    private final UsuarioDAO usuarioDAO;
    private final PersonaDAO personaDAO;
    private final EmpleadoDAO empleadoDAO;
    private final GerenteDAO gerenteDAO;

    public GerenteService(UsuarioDAO usuarioDAO, PersonaDAO personaDAO, EmpleadoDAO empleadoDAO, GerenteDAO gerenteDAO) {
        this.usuarioDAO = usuarioDAO;
        this.personaDAO = personaDAO;
        this.empleadoDAO = empleadoDAO;
        this.gerenteDAO = gerenteDAO;
    }

    public boolean registrar(Usuario usuario, Gerente gerente) throws Exception {
        Connection connection = null;

        try {
            connection = ConexionSQLite.getConnection();
            connection.setAutoCommit(false);

            int idInsertado = usuarioDAO.registrar(connection, usuario);

            if (idInsertado != 0) {

                gerente.setIdPersona(idInsertado);
                boolean exito = personaDAO.registrar(connection, (Persona)gerente);

                if (!exito) {
                    throw new Exception("No se pudo registrar la persona asociada al gerente");
                }

                gerente.setIdEmpleado(idInsertado);
                exito = empleadoDAO.registrar(connection, (Empleado)gerente);

                if (!exito) {
                    throw new Exception("No se pudo registrar el empleado asociado al gerente");
                }

                gerente.setIdGerente(idInsertado);
                exito = gerenteDAO.registrar(connection, gerente);

                if (!exito) {
                    throw new Exception("No se pudo registrar el gerente");
                }
            }

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }

        return true;
    }

    public boolean editar(Gerente gerente) throws Exception {
        Connection connection = null;

        try {
            connection = ConexionSQLite.getConnection();
            connection.setAutoCommit(false);

            boolean exito = gerenteDAO.editar(connection, gerente);

            if (!exito) {
                throw new Exception("No se pudo editar el gerente");
            }

            exito = empleadoDAO.editar(connection, (Empleado)gerente);

            if (!exito) {
                throw new Exception("No se pudo editar el empleado asociado al gerente");
            }

            exito = personaDAO.editar(connection, (Persona)gerente);

            if (!exito) {
                throw new Exception("No se pudo editar la persona asociada al gerente");
            }

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }

        return true;
    }
}
