package alquilervehiculos.config;

import alquilervehiculos.controller.ClienteController;
import alquilervehiculos.controller.UsuarioController;

public class AppContext {
    private static UsuarioController usuarioController;
    private static ClienteController clienteController;

    private AppContext() {
        // Constructor privado para evitar instanciación (patrón Singleton)
    }

    public static void init(UsuarioController usuarioControllerToInject, ClienteController clienteControllerToInject) {
        usuarioController = usuarioControllerToInject;
        clienteController = clienteControllerToInject;
    }

    public static UsuarioController getUsuarioController() {
        return usuarioController;
    }

    public static ClienteController getClienteController() {
        return clienteController;
    }
}
