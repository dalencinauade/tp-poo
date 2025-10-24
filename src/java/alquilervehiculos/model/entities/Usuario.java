package alquilervehiculos.model.entities;

import java.util.Date;

import alquilervehiculos.model.enums.EstadoUsuarioEnum;
import alquilervehiculos.model.enums.UsuarioRolEnum;

public class Usuario {
    private int idUsuario;
    private String username;
    private String password;
    private UsuarioRolEnum rol;
    private Date fechaCreacion;
    private Date ultimoAcceso;
    private EstadoUsuarioEnum estado;

    public Usuario(int idUsuario, String username, String password, UsuarioRolEnum rol, Date fechaCreacion,
            Date ultimoAcceso, EstadoUsuarioEnum estado) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.fechaCreacion = fechaCreacion;
        this.ultimoAcceso = ultimoAcceso;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public UsuarioRolEnum getRol() {
        return rol;
    }

    public void setRol(UsuarioRolEnum rol) {
        this.rol = rol;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public EstadoUsuarioEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuarioEnum estado) {
        this.estado = estado;
    }
}
