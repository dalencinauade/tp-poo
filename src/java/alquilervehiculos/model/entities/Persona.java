package alquilervehiculos.model.entities;

public class Persona {
    private int dni;
    private String telefono;
    private String direccion;

    public Persona(int dni, String telefono, String direccion) {
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Getters y Setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
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
}
