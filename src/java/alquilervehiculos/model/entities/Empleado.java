package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.TurnoEmpleadoEnum;

public abstract class Empleado extends Persona {
    private int legajo;
    private double salario;
    private TurnoEmpleadoEnum turno;

    public Empleado(int dni, int legajo) {
        super(dni);
        this.legajo = legajo;
    }

    // Getters y Setters
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
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
