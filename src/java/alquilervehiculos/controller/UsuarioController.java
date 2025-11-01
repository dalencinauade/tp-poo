package alquilervehiculos.controller;

import alquilervehiculos.model.entities.Respuesta;
import alquilervehiculos.model.entities.Sesion;
import alquilervehiculos.service.UsuarioService;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Respuesta login(String username, String password) {
        boolean exito = false;
        String mensaje = "";

        try {
            exito = usuarioService.login(username, password);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return new Respuesta(exito, mensaje);
    }

    public void logout() {
        usuarioService.logout();
    }

    public Sesion getSesionActual() {
        return usuarioService.getSesionActual();
    }

    public boolean existeSesionActiva() {
        return usuarioService.existeSesionActiva();
    }
}
