package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.UsuarioRolEnum;
import java.util.Date;

public class Sesion {
    private int id;
    private String email;
    private UsuarioRolEnum rol;
    private Date fechaInicio;
    private Date fechaUltimoAcceso;

    public Sesion(int id, String email, UsuarioRolEnum rol) {
        this.id = id;
        this.email = email;
        this.rol = rol;
        this.fechaInicio = new Date(); // Se inicializa automáticamente al crear la sesión
        this.fechaUltimoAcceso = new Date();
    }

    public Sesion(int id, String email, UsuarioRolEnum rol, Date fechaInicio, Date fechaUltimoAcceso) {
        this.id = id;
        this.email = email;
        this.rol = rol;
        this.fechaInicio = fechaInicio;
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioRolEnum getRol() {
        return rol;
    }

    public void setRol(UsuarioRolEnum rol) {
        this.rol = rol;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    public void actualizarUltimoAcceso() {
        this.fechaUltimoAcceso = new Date();
    }
}