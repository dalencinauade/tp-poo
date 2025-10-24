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

    // TODO: getters, setters and methods needed.
}
