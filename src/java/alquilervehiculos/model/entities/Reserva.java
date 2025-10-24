package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.EstadoReservaEnum;
import java.util.Date;

public class Reserva {
    private int idReserva;
    private Date fechaReserva;
    private Date fechaInicio;
    private Date fechaFin;
    private int diasReserva;
    private double costoEstimado;
    private EstadoReservaEnum estado;
    private Cliente cliente; // Relación N:1 con Cliente
    private Vehiculo vehiculo; // Relación N:1 con Vehiculo

    public Reserva(int idReserva, Date fechaReserva, Date fechaInicio, Date fechaFin, 
            int diasReserva, double costoEstimado, EstadoReservaEnum estado, 
            Cliente cliente, Vehiculo vehiculo) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.diasReserva = diasReserva;
        this.costoEstimado = costoEstimado;
        this.estado = estado;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
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

    public EstadoReservaEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoReservaEnum estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
