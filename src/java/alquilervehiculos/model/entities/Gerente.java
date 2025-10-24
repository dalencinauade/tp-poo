package alquilervehiculos.model.entities;

import java.util.Date;

public class Gerente extends Empleado {
    private int idGerente;
    private double bonoRendimiento;
    private Date fechaInicioComoGerente;
    private double metaVentasMensual;

    public Gerente(int dni, String nombre, String apellido, String email,
            String legajo, int idGerente, double bonoRendimiento, Date fechaInicioComoGerente,
            double metaVentasMensual) {
        super(dni, nombre, apellido, email, legajo);
        this.idGerente = idGerente;
        this.bonoRendimiento = bonoRendimiento;
        this.fechaInicioComoGerente = fechaInicioComoGerente;
        this.metaVentasMensual = metaVentasMensual;
    }

    // Getters y Setters
    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
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
