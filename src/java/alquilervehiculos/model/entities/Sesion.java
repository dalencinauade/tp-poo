package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.UsuarioRolEnum;

public class Sesion {
    private int id;
    private String email;
    private UsuarioRolEnum rol;

    public Sesion(int id, String email, UsuarioRolEnum rol) {
        this.id = id;
        this.email = email;
        this.rol = rol;
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
}