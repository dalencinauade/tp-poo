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

    // Métodos de negocio
    
    /**
     * Verifica si el usuario está activo
     */
    public boolean estaActivo() {
        return this.estado == EstadoUsuarioEnum.ACTIVO;
    }

    /**
     * Verifica si el usuario está bloqueado
     */
    public boolean estaBloqueado() {
        return this.estado == EstadoUsuarioEnum.BLOQUEADO;
    }

    /**
     * Activa el usuario
     */
    public void activar() {
        this.estado = EstadoUsuarioEnum.ACTIVO;
    }

    /**
     * Suspende el usuario
     */
    public void suspender() {
        this.estado = EstadoUsuarioEnum.SUSPENDIDO;
    }

    /**
     * Bloquea el usuario
     */
    public void bloquear() {
        this.estado = EstadoUsuarioEnum.BLOQUEADO;
    }

    /**
     * Actualiza la fecha de último acceso
     */
    public void actualizarUltimoAcceso() {
        this.ultimoAcceso = new Date();
    }

    /**
     * Verifica si es administrador
     */
    public boolean esAdmin() {
        return this.rol == UsuarioRolEnum.ADMIN;
    }

    /**
     * Verifica si es gerente
     */
    public boolean esGerente() {
        return this.rol == UsuarioRolEnum.GERENTE;
    }

    /**
     * Verifica si es administrativo
     */
    public boolean esAdministrativo() {
        return this.rol == UsuarioRolEnum.ADMINISTRATIVO;
    }

    /**
     * Verifica si es técnico
     */
    public boolean esTecnico() {
        return this.rol == UsuarioRolEnum.TECNICO;
    }

    /**
     * Verifica si es cliente
     */
    public boolean esCliente() {
        return this.rol == UsuarioRolEnum.CLIENTE;
    }
}
