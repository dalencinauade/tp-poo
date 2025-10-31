package alquilervehiculos.model.entities;

import java.util.Date;

import alquilervehiculos.model.enums.RolUsuarioEnum;

public abstract class Persona extends Usuario {
    private int idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private String telefono;
    private String direccion;
    private Date fechaNacimiento;
    private Usuario usuario; // Relación 1:1 con Usuario

    public Persona(String nombre, String apellido, String email, String dni, String telefono, String direccion, Date fechaNacimiento, String username, String password, RolUsuarioEnum rol) {
        super(username, password, rol);
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters
    public int getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
