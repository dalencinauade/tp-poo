package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.TurnoEmpleadoEnum;

public abstract class Empleado extends Persona {
    private String legajo;
    private double salario;
    private TurnoEmpleadoEnum turno;

    public Empleado(int dni, String nombre, String apellido, String email, String legajo) {
        super(dni, nombre, apellido, email);
        this.legajo = legajo;
    }

    // Getters y Setters
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

    public TurnoEmpleadoEnum getTurno() {
        return turno;
    }

    public void setTurno(TurnoEmpleadoEnum turno) {
        this.turno = turno;
    }
}
