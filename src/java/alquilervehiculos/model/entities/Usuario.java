package alquilervehiculos.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import alquilervehiculos.model.enums.RolUsuarioEnum;

public class Usuario {
    private int idUsuario;
    private String username;
    private String password;
    private RolUsuarioEnum rol;
    private Date fechaCreacion;

    public Usuario(String username, String password, RolUsuarioEnum rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.fechaCreacion = new Date();
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolUsuarioEnum getRol() {
        return rol;
    }

    public void setRol(RolUsuarioEnum rol) {
        this.rol = rol;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaCreacionString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fechaCreacion);
    }

    // Métodos de negocio

    /**
     * Verifica si es administrador
     */
    public boolean esAdmin() {
        return this.rol == RolUsuarioEnum.ADMIN;
    }

    /**
     * Verifica si es gerente
     */
    public boolean esGerente() {
        return this.rol == RolUsuarioEnum.GERENTE;
    }

    /**
     * Verifica si es administrativo
     */
    public boolean esAdministrativo() {
        return this.rol == RolUsuarioEnum.ADMINISTRATIVO;
    }

    /**
     * Verifica si es técnico
     */
    public boolean esTecnico() {
        return this.rol == RolUsuarioEnum.TECNICO;
    }

    /**
     * Verifica si es cliente
     */
    public boolean esCliente() {
        return this.rol == RolUsuarioEnum.CLIENTE;
    }
}
