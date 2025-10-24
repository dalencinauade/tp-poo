package alquilervehiculos.model.entities;

import java.util.Date;

public class Contrato {
    private int idContrato;
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaDevolucionReal;
    private double costoEstimado;
    private double costoTotal;
    private String terminosCondiciones;
    private String firmaCliente;

    public Contrato(int idContrato, Date fechaInicio, Date fechaFin, Date fechaDevolucionReal, double costoEstimado,
            double costoTotal, String terminosCondiciones, String firmaCliente) {
        this.idContrato = idContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.costoEstimado = costoEstimado;
        this.costoTotal = costoTotal;
        this.terminosCondiciones = terminosCondiciones;
        this.firmaCliente = firmaCliente;
    }

    // Getters y Setters
    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(Date fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public double getCostoEstimado() {
        return costoEstimado;
    }

    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getTerminosCondiciones() {
        return terminosCondiciones;
    }

    public void setTerminosCondiciones(String terminosCondiciones) {
        this.terminosCondiciones = terminosCondiciones;
    }

    public String getFirmaCliente() {
        return firmaCliente;
    }

    public void setFirmaCliente(String firmaCliente) {
        this.firmaCliente = firmaCliente;
    }
}
