package alquilervehiculos.service;

import java.sql.Connection;

import alquilervehiculos.dao.AdministrativoDAO;
import alquilervehiculos.dao.ConexionSQLite;
import alquilervehiculos.dao.EmpleadoDAO;
import alquilervehiculos.dao.PersonaDAO;
import alquilervehiculos.dao.UsuarioDAO;
import alquilervehiculos.model.entities.Administrativo;
import alquilervehiculos.model.entities.Empleado;
import alquilervehiculos.model.entities.Persona;
import alquilervehiculos.model.entities.Usuario;

public class AdministrativoService {
    private final UsuarioDAO usuarioDAO;
    private final PersonaDAO personaDAO;
    private final EmpleadoDAO empleadoDAO;
    private final AdministrativoDAO administrativoDAO;

    public AdministrativoService(UsuarioDAO usuarioDAO, PersonaDAO personaDAO, EmpleadoDAO empleadoDAO, AdministrativoDAO administrativoDAO) {
        this.usuarioDAO = usuarioDAO;
        this.personaDAO = personaDAO;
        this.empleadoDAO = empleadoDAO;
        this.administrativoDAO = administrativoDAO;
    }

    public boolean registrar(Usuario usuario, Administrativo administrativo) throws Exception {
        Connection connection = null;

        try {
            connection = ConexionSQLite.getConnection();
            connection.setAutoCommit(false);

            int idInsertado = usuarioDAO.registrar(connection, usuario);

            if (idInsertado != 0) {

                administrativo.setIdPersona(idInsertado);
                boolean exito = personaDAO.registrar(connection, (Persona)administrativo);

                if (!exito) {
                    throw new Exception("No se pudo registrar la persona asociada al administrativo");
                }

                administrativo.setIdEmpleado(idInsertado);
                exito = empleadoDAO.registrar(connection, (Empleado)administrativo);

                if (!exito) {
                    throw new Exception("No se pudo registrar el empleado asociado al administrativo");
                }

                administrativo.setIdAdministrativo(idInsertado);
                exito = administrativoDAO.registrar(connection, administrativo);

                if (!exito) {
                    throw new Exception("No se pudo registrar el administrativo");
                }
            }

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }

        return true;
    }

    public boolean editar(Administrativo administrativo) throws Exception {
        Connection connection = null;

        try {
            connection = ConexionSQLite.getConnection();
            connection.setAutoCommit(false);

            boolean exito = personaDAO.editar(connection, (Persona)administrativo);

            if (!exito) {
                throw new Exception("No se pudo editar la persona asociada al administrativo");
            }

            exito = empleadoDAO.editar(connection, (Empleado)administrativo);

            if (!exito) {
                throw new Exception("No se pudo editar el empleado asociado al administrativo");
            }

            exito = administrativoDAO.editar(connection, administrativo);

            if (!exito) {
                throw new Exception("No se pudo editar el administrativo");
            }

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }

        return true;
    }
}
