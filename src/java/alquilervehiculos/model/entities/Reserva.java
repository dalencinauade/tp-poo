package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.EstadoReservaEnum;
import java.util.Date;

public class Reserva {
    private int idReserva;
    private Date fechaReserva;
    private Date fechaInicio;
    private Date fechaFin;
    private double costoEstimado;
    private EstadoReservaEnum estado;
    private Cliente cliente; // Relación N:1 con Cliente
    private Vehiculo vehiculo; // Relación N:1 con Vehiculo

    public Reserva(Date fechaInicio, Date fechaFin, Double costoEstimado) {
        this.fechaReserva = new Date();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = EstadoReservaEnum.PENDIENTE;
        this.costoEstimado = costoEstimado;
        //this.cliente = cliente;
        //this.vehiculo = vehiculo;
    }

    // Getters y Setters
    public int getIdReserva() {
        return idReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
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

    // Métodos de negocio

    /**
     * Cancela la reserva y libera el vehículo
     */
    public void cancelar() {
        this.estado = EstadoReservaEnum.CANCELADA;
        if (this.vehiculo != null) {
            this.vehiculo.setEstado(alquilervehiculos.model.enums.EstadoVehiculoEnum.DISPONIBLE);
        }
    }

    /**
     * Convierte la reserva en alquiler
     * 
     * @return true si se puede convertir, false si no
     */
    public boolean convertirAAlquiler() {
        if (this.estado == EstadoReservaEnum.PENDIENTE) {
            this.estado = EstadoReservaEnum.CONVERTIDA_ALQUILER;
            return true;
        }
        return false;
    }

    /**
     * Verifica si la reserva está activa (confirmada o pendiente)
     */
    public boolean estaActiva() {
        return this.estado == EstadoReservaEnum.PENDIENTE;
    }
}
