package alquilervehiculos.service;

import java.sql.Connection;

import alquilervehiculos.dao.ClienteDAO;
import alquilervehiculos.dao.ConexionSQLite;
import alquilervehiculos.dao.PersonaDAO;
import alquilervehiculos.dao.UsuarioDAO;
import alquilervehiculos.model.entities.Cliente;
import alquilervehiculos.model.entities.Persona;
import alquilervehiculos.model.entities.Sesion;
import alquilervehiculos.model.entities.Usuario;

public class UsuarioService {
    private final UsuarioDAO usuarioDAO;
    private final PersonaDAO personaDAO;
    private final ClienteDAO clienteDAO;
    private Sesion sesionActual;

    public UsuarioService(UsuarioDAO usuarioDAO, PersonaDAO personaDAO, ClienteDAO clienteDAO) {
        this.usuarioDAO = usuarioDAO;
        this.personaDAO = personaDAO;
        this.clienteDAO = clienteDAO;
    }

    public boolean login(String username, String password) throws Exception {
        Sesion sesion = usuarioDAO.login(username, password);

        if (sesion != null) {
            this.sesionActual = sesion;
            return true;
        }

        return false;
    }

    public boolean registrarCliente(Usuario usuario, Cliente cliente) throws Exception {
        Connection connection = null;

        try {
            connection = ConexionSQLite.getConnection();
            connection.setAutoCommit(false);

            int idInsertado = usuarioDAO.registrar(connection, usuario);

            if (idInsertado != 0) {
                cliente.setIdPersona(idInsertado);
                boolean exito = personaDAO.registrar(connection, (Persona)cliente);

                if (!exito) {
                    throw new Exception("No se pudo registrar la persona asociada al cliente");
                }
                
                cliente.setIdCliente(idInsertado);
                exito = clienteDAO.registrar(connection, cliente);

                if (!exito) {
                    throw new Exception("No se pudo registrar el cliente");
                }
            }

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }

        return true;
    }

    public void logout() {
        this.sesionActual = null;
    }

    public boolean existeSesionActiva() {
        return this.sesionActual != null;
    }

    public Sesion getSesionActual() {
        return this.sesionActual;
    }
}
