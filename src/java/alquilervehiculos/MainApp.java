package alquilervehiculos;

import alquilervehiculos.dao.ConexionSQLite;
import alquilervehiculos.service.LoginService;
import alquilervehiculos.util.ConsoleUtils;
import alquilervehiculos.controller.LoginController;
import alquilervehiculos.dao.UsuarioDAO;

public class MainApp {
    public static void main(String[] args) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            LoginService loginService = new LoginService(usuarioDAO);
            LoginController loginController = new LoginController(loginService);

            loginController.iniciarSesion();
        } catch (Exception e) {
            ConsoleUtils.pause("Error en la aplicación: " + e.getMessage());
            e.printStackTrace();
        } finally {
            ConexionSQLite.closeConnection();
        }
    }
}
