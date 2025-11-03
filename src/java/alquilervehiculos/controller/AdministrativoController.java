package alquilervehiculos.controller;

import java.util.Date;

import alquilervehiculos.model.entities.Administrativo;
import alquilervehiculos.model.entities.Respuesta;
import alquilervehiculos.model.entities.Usuario;
import alquilervehiculos.model.enums.RolUsuarioEnum;
import alquilervehiculos.service.AdministrativoService;

public class AdministrativoController {
    private AdministrativoService administrativoService;

    public AdministrativoController(AdministrativoService administrativoService) {
        this.administrativoService = administrativoService;
    }
    
    public Respuesta registrar(String nombre, String apellido, String email, String dni, String telefono, String direccion,
    Date fechaNacimiento, String username, String password, String legajo, String salario, String metaAlquileresMensual,
    String idiomas) {
        boolean exito = false;
        String mensaje = "";

        try {
            Usuario usuario = new Usuario(username, password, RolUsuarioEnum.ADMINISTRATIVO);
            Administrativo administrativo = new Administrativo(Integer.parseInt(metaAlquileresMensual), idiomas, legajo, Double.parseDouble(salario), nombre, apellido, email, dni, telefono, direccion, fechaNacimiento);

            exito = administrativoService.registrar(usuario, administrativo);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return new Respuesta(exito, mensaje);
    }

    public Respuesta editar(int idUsuario, String nombre, String apellido, String email, String dni, String telefono, String direccion,
    Date fechaNacimiento, String legajo, double salario, int metaAlquileresMensual, String idiomas) {
        boolean exito = false;
        String mensaje = "";

        try {
            Administrativo administrativo = new Administrativo(metaAlquileresMensual, idiomas, legajo, salario, nombre, apellido, email, dni, telefono, direccion, fechaNacimiento);
            administrativo.setIdAdministrativo(idUsuario);
            administrativo.setIdEmpleado(idUsuario);
            administrativo.setIdPersona(idUsuario);

            exito = administrativoService.editar(administrativo);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return new Respuesta(exito, mensaje);
    }
}
