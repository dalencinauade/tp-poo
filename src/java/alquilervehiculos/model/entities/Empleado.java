package alquilervehiculos.model.entities;

import java.util.Date;

import alquilervehiculos.model.enums.TurnoEmpleadoEnum;
import alquilervehiculos.model.enums.RolUsuarioEnum;

public abstract class Empleado extends Persona {
    private int legajo;
    private double salario;
    private TurnoEmpleadoEnum turno;

    public Empleado(double salario, TurnoEmpleadoEnum turno, String nombre, String apellido, String email, String dni, String telefono, String direccion, Date fechaNacimiento, String username, String password, RolUsuarioEnum rol) {
        super(nombre, apellido, email, dni, telefono, direccion, fechaNacimiento, username, password, rol);
        
        this.salario = salario;
        this.turno = turno;
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
