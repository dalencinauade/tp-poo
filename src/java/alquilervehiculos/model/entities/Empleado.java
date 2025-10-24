package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.TurnoEmpleadoEnum;

public class Empleado extends Persona {
    private String legajo;
    private double salario;
    private TurnoEmpleadoEnum turno;

    public Empleado(int dni, String telefono, String direccion, String legajo, double salario,
            TurnoEmpleadoEnum turno) {
        super(dni, telefono, direccion);
        this.legajo = legajo;
        this.salario = salario;
        this.turno = turno;
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
