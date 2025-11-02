package alquilervehiculos.model.entities;

import java.util.Date;

public abstract class Empleado extends Persona {
    private int idEmpleado;
    private String legajo;
    private double salario;

    public Empleado(String legajo, double salario, String nombre, String apellido, String email, String dni, String telefono, String direccion, Date fechaNacimiento) {
        super(nombre, apellido, email, dni, telefono, direccion, fechaNacimiento);
        
        this.legajo = legajo;
        this.salario = salario;
    }

    // Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
