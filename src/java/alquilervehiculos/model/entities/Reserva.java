package alquilervehiculos.model.entities;

import java.util.Date;

public class Reserva {
    private int idReserva;
    private Date fechaReserva;
    private int diasReserva;
    private double costoEstimado;

    public Reserva(int idReserva, Date fechaReserva, int diasReserva, double costoEstimado) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.diasReserva = diasReserva;
        this.costoEstimado = costoEstimado;
    }

    // Getters y Setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getDiasReserva() {
        return diasReserva;
    }

    public void setDiasReserva(int diasReserva) {
        this.diasReserva = diasReserva;
    }

    public double getCostoEstimado() {
        return costoEstimado;
    }

    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }
}
