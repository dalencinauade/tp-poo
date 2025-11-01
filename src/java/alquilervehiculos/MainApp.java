package alquilervehiculos;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.ClienteController;
import alquilervehiculos.controller.UsuarioController;
import alquilervehiculos.dao.ClienteDAO;
import alquilervehiculos.dao.PersonaDAO;
import alquilervehiculos.dao.UsuarioDAO;
import alquilervehiculos.service.UsuarioService;
import alquilervehiculos.ui.Login;

public class MainApp {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PersonaDAO personaDAO = new PersonaDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        UsuarioService usuarioService = new UsuarioService(usuarioDAO, personaDAO, clienteDAO);
        UsuarioController usuarioController = new UsuarioController(usuarioService);
        ClienteController clienteController = new ClienteController(usuarioService);

        AppContext.init(usuarioController, clienteController);

        javax.swing.SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
