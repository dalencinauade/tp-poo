package alquilervehiculos.model.entities;

import java.util.Date;

public class Gerente {
    private int idGerente;
    private double bonoRendimiento;
    private Date fechaInicioComoGerente;
    private double metaVentasMensual;

    public Gerente(int id, double bonoRendimiento, Date fechaInicioComoGerente, double metaVentasMensual) {
        this.idGerente = id;
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
