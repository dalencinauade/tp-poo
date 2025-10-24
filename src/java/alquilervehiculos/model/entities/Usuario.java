package alquilervehiculos.model.entities;

import java.util.Date;

import alquilervehiculos.model.enums.EstadoUsuarioEnum;
import alquilervehiculos.model.enums.RolUsuarioEnum;

public class Usuario {
    private int idUsuario;
    private String username;
    private String password;
    private RolUsuarioEnum rol;
    private Date fechaCreacion;
    private Date ultimoAcceso;
    private EstadoUsuarioEnum estado;

    public Usuario(int idUsuario, String username, String password, RolUsuarioEnum rol, Date fechaCreacion,
            Date ultimoAcceso, EstadoUsuarioEnum estado) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.fechaCreacion = fechaCreacion;
        this.ultimoAcceso = ultimoAcceso;
        this.estado = estado;
    }

    // TODO: getters, setters and methods needed.
}
