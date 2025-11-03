package alquilervehiculos.service;

import java.sql.Connection;

import alquilervehiculos.dao.ConexionSQLite;
import alquilervehiculos.dao.EmpleadoDAO;
import alquilervehiculos.dao.PersonaDAO;
import alquilervehiculos.dao.TecnicoDAO;
import alquilervehiculos.dao.UsuarioDAO;
import alquilervehiculos.model.entities.Empleado;
import alquilervehiculos.model.entities.Persona;
import alquilervehiculos.model.entities.Tecnico;
import alquilervehiculos.model.entities.Usuario;

public class TecnicoService {
    private final UsuarioDAO usuarioDAO;
    private final PersonaDAO personaDAO;
    private final EmpleadoDAO empleadoDAO;
    private final TecnicoDAO tecnicoDAO;

    public TecnicoService(UsuarioDAO usuarioDAO, PersonaDAO personaDAO, EmpleadoDAO empleadoDAO, TecnicoDAO tecnicoDAO) {
        this.usuarioDAO = usuarioDAO;
        this.personaDAO = personaDAO;
        this.empleadoDAO = empleadoDAO;
        this.tecnicoDAO = tecnicoDAO;
    }
    
    public boolean registrar(Usuario usuario, Tecnico tecnico) throws Exception {
        Connection connection = null;

        try {
            connection = ConexionSQLite.getConnection();
            connection.setAutoCommit(false);

            int idInsertado = usuarioDAO.registrar(connection, usuario);

            if (idInsertado != 0) {

                tecnico.setIdPersona(idInsertado);
                boolean exito = personaDAO.registrar(connection, (Persona)tecnico);

                if (!exito) {
                    throw new Exception("No se pudo registrar la persona asociada al técnico");
                }

                tecnico.setIdEmpleado(idInsertado);
                exito = empleadoDAO.registrar(connection, (Empleado)tecnico);

                if (!exito) {
                    throw new Exception("No se pudo registrar el empleado asociado al técnico");
                }

                tecnico.setIdTecnico(idInsertado);
                exito = tecnicoDAO.registrar(connection, tecnico);

                if (!exito) {
                    throw new Exception("No se pudo registrar el técnico");
                }
            }

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }

        return true;
    }

    public boolean editar(Tecnico tecnico) throws Exception {
        Connection connection = null;

        try {
            connection = ConexionSQLite.getConnection();
            connection.setAutoCommit(false);

            boolean exito = empleadoDAO.editar(connection, (Empleado)tecnico);

            if (!exito) {
                throw new Exception("No se pudo editar el empleado asociado al técnico");
            }

            exito = personaDAO.editar(connection, (Persona)tecnico);

            if (!exito) {
                throw new Exception("No se pudo editar la persona asociada al técnico");
            }

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }

        return true;
    }
}
