package alquilervehiculos.controller;

import java.util.Date;

import alquilervehiculos.model.entities.Cliente;
import alquilervehiculos.model.entities.Respuesta;
import alquilervehiculos.model.entities.Usuario;
import alquilervehiculos.model.enums.RolUsuarioEnum;
import alquilervehiculos.service.UsuarioService;

public class ClienteController {
    private UsuarioService usuarioService;

    public ClienteController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Respuesta registrar(String nombre, String apellido, String email, String dni, String telefono, String direccion,
    Date fechaNacimiento, String numeroLicencia, Date fechaVencimientoLicencia, String username, String password) {
        boolean exito = false;
        String mensaje = "";

        try {
            Usuario usuario = new Usuario(username, password, RolUsuarioEnum.CLIENTE);
            Cliente cliente = new Cliente(numeroLicencia, fechaVencimientoLicencia, nombre, apellido, email, dni, telefono, direccion, fechaNacimiento);

            exito = usuarioService.registrarCliente(usuario, cliente);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return new Respuesta(exito, mensaje);
    }
}
