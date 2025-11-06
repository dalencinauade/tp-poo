package alquilervehiculos.controller;

import java.util.Date;

import alquilervehiculos.model.dto.ClienteObtenerDatosInterfazDTO;
import alquilervehiculos.model.entities.Cliente;
import alquilervehiculos.model.entities.Respuesta;
import alquilervehiculos.model.entities.Usuario;
import alquilervehiculos.model.enums.RolUsuarioEnum;
import alquilervehiculos.service.ClienteService;

public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Respuesta registrar(String nombre, String apellido, String email, String dni, String telefono, String direccion,
    Date fechaNacimiento, String numeroLicencia, Date fechaVencimientoLicencia, String username, String password) {
        boolean exito = false;
        String mensaje = "";

        try {
            Usuario usuario = new Usuario(username, password, RolUsuarioEnum.CLIENTE);
            Cliente cliente = new Cliente(numeroLicencia, fechaVencimientoLicencia, nombre, apellido, email, dni, telefono, direccion, fechaNacimiento);

            exito = clienteService.registrar(usuario, cliente);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return new Respuesta(exito, mensaje);
    }

    public Respuesta editar(int idUsuario, String nombre, String apellido, String email, String dni, String telefono, String direccion,
    Date fechaNacimiento, String numeroLicencia, Date fechaVencimientoLicencia) {
        boolean exito = false;
        String mensaje = "";

        try {
            Cliente cliente = new Cliente(numeroLicencia, fechaVencimientoLicencia, nombre, apellido, email, dni, telefono, direccion, fechaNacimiento);
            cliente.setIdCliente(idUsuario);
            cliente.setIdPersona(idUsuario);

            exito = clienteService.editar(cliente);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return new Respuesta(exito, mensaje);
    }

    public ClienteObtenerDatosInterfazDTO obtenerDatosInterfaz(int idUsuario) {
        try {
            return clienteService.obtenerDatosInterfaz(idUsuario);
        }
        catch (Exception e) {
            return null;
        }
    }
}
