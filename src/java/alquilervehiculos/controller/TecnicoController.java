package alquilervehiculos.controller;

import java.util.Date;

import alquilervehiculos.model.entities.Respuesta;
import alquilervehiculos.model.entities.Tecnico;
import alquilervehiculos.model.entities.Usuario;
import alquilervehiculos.model.enums.RolUsuarioEnum;
import alquilervehiculos.service.TecnicoService;

public class TecnicoController {
    private TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    public Respuesta registrar(String nombre, String apellido, String email, String dni, String telefono, String direccion,
    Date fechaNacimiento, String username, String password, String legajo, String salario) {
        boolean exito = false;
        String mensaje = "";

        try {
            Usuario usuario = new Usuario(username, password, RolUsuarioEnum.TECNICO);
            Tecnico tecnico = new Tecnico(legajo, Double.parseDouble(salario), nombre, apellido, email, dni, telefono, direccion, fechaNacimiento);

            exito = tecnicoService.registrar(usuario, tecnico);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return new Respuesta(exito, mensaje);
    }

    public Respuesta editar(int idUsuario, String nombre, String apellido, String email, String dni, String telefono, String direccion,
    Date fechaNacimiento, String legajo, Double salario) {
        boolean exito = false;
        String mensaje = "";

        try {
            Tecnico tecnico = new Tecnico(legajo, salario, nombre, apellido, email, dni, telefono, direccion, fechaNacimiento);
            tecnico.setIdTecnico(idUsuario);
            tecnico.setIdEmpleado(idUsuario);
            tecnico.setIdPersona(idUsuario);

            exito = tecnicoService.editar(tecnico);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return new Respuesta(exito, mensaje);
    }
}
