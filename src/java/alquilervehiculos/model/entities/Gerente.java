package alquilervehiculos.model.entities;

import java.util.Date;

import alquilervehiculos.model.enums.TurnoEmpleadoEnum;

public class Gerente extends Empleado {
    private int idGerente;
    private double bonoRendimiento;
    private Date fechaInicioComoGerente;
    private double metaVentasMensual;

    public Gerente(double bonoRendimiento, Date fechaInicioComoGerente, double metaVentasMensual, double salario, TurnoEmpleadoEnum turno, String nombre, String apellido, String email, String dni, String telefono, String direccion, Date fechaNacimiento) {
        super(salario, turno, nombre, apellido, email, dni, telefono, direccion, fechaNacimiento);
        
        this.bonoRendimiento = bonoRendimiento;
        this.fechaInicioComoGerente = fechaInicioComoGerente;
        this.metaVentasMensual = metaVentasMensual;
    }

    // Getters y Setters
    public int getIdGerente() {
        return idGerente;
    }

    public double getBonoRendimiento() {
        return bonoRendimiento;
    }

    public void setBonoRendimiento(double bonoRendimiento) {
        this.bonoRendimiento = bonoRendimiento;
    }

    public Date getFechaInicioComoGerente() {
        return fechaInicioComoGerente;
    }

    public void setFechaInicioComoGerente(Date fechaInicioComoGerente) {
        this.fechaInicioComoGerente = fechaInicioComoGerente;
    }

    public double getMetaVentasMensual() {
        return metaVentasMensual;
    }

    public void setMetaVentasMensual(double metaVentasMensual) {
        this.metaVentasMensual = metaVentasMensual;
    }
}
