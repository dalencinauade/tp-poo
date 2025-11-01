package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.RolUsuarioEnum;

public class Sesion {
    private int id;
    private String username;
    private String nombre;
    private RolUsuarioEnum rol;

    public Sesion(int id, String username, String nombre, RolUsuarioEnum rol) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public RolUsuarioEnum getRol() {
        return rol;
    }

    public void setRol(RolUsuarioEnum rol) {
        this.rol = rol;
    }
}