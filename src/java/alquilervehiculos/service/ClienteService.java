package alquilervehiculos.service;

import java.sql.Connection;

import alquilervehiculos.dao.ClienteDAO;
import alquilervehiculos.dao.ConexionSQLite;
import alquilervehiculos.dao.PersonaDAO;
import alquilervehiculos.dao.UsuarioDAO;
import alquilervehiculos.model.entities.Cliente;
import alquilervehiculos.model.entities.Persona;
import alquilervehiculos.model.entities.Usuario;

public class ClienteService {
    private final UsuarioDAO usuarioDAO;
    private final PersonaDAO personaDAO;
    private final ClienteDAO clienteDAO;

    public ClienteService(UsuarioDAO usuarioDAO, PersonaDAO personaDAO, ClienteDAO clienteDAO) {
        this.usuarioDAO = usuarioDAO;
        this.personaDAO = personaDAO;
        this.clienteDAO = clienteDAO;
    }

    public boolean registrar(Usuario usuario, Cliente cliente) throws Exception {
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
}
