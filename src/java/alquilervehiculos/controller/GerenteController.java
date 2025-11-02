package alquilervehiculos.controller;

import java.util.Date;

import alquilervehiculos.model.entities.Gerente;
import alquilervehiculos.model.entities.Respuesta;
import alquilervehiculos.model.entities.Usuario;
import alquilervehiculos.model.enums.RolUsuarioEnum;
import alquilervehiculos.service.GerenteService;

public class GerenteController {
    private GerenteService gerenteService;

    public GerenteController(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }
    
    public Respuesta registrar(String nombre, String apellido, String email, String dni, String telefono, String direccion,
    Date fechaNacimiento, String username, String password, String legajo, String salario, String bonoRendimiento,
    Date fechaInicioComoGerente, String metaVentasMensual) { 
        boolean exito = false;
        String mensaje = "";

        try {
            Usuario usuario = new Usuario(username, password, RolUsuarioEnum.CLIENTE);
            Gerente gerente = new Gerente(Double.parseDouble(bonoRendimiento), fechaInicioComoGerente, Double.parseDouble(metaVentasMensual), legajo, Double.parseDouble(salario), nombre, apellido, email, dni, telefono, direccion, fechaNacimiento);

            exito = gerenteService.registrar(usuario, gerente);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return new Respuesta(exito, mensaje);
    }
}
