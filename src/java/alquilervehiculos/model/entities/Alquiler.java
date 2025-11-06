package alquilervehiculos.model.entities;

import java.util.Date;

import alquilervehiculos.model.enums.EstadoAlquilerEnum;

public class Alquiler {
    private int idAlquiler;
    private Date fechaInicio;
    private Date fechaDevolucionPrevista;
    private Date fechaDevolucionReal;
    private int kilometrajeInicial;
    private int kilometrajeFinal;
    private double nivelCombustibleInicial;
    private double nivelCombustibleFinal;
    private EstadoAlquilerEnum estado;
    private Factura factura; // Relación 1:1 con Factura

    public Alquiler(Reserva reserva) {
        this.fechaInicio = reserva.getFechaInicio();
        this.fechaDevolucionPrevista = reserva.getFechaFin();
        this.fechaDevolucionReal = null;
        this.kilometrajeInicial = reserva.getVehiculo().getKilometraje();
        this.nivelCombustibleInicial = reserva.getVehiculo().getCapacidadTanque();
        this.estado = EstadoAlquilerEnum.VIGENTE;
        this.factura = null;
    }

    // Getters y Setters
    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaDevolucionPrevista() {
        return fechaDevolucionPrevista;
    }

    public void setFechaDevolucionPrevista(Date fechaDevolucionPrevista) {
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
    }

    public Date getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(Date fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public int getKilometrajeInicial() {
        return kilometrajeInicial;
    }

    public void setKilometrajeInicial(int kilometrajeInicial) {
        this.kilometrajeInicial = kilometrajeInicial;
    }

    public double getNivelCombustibleInicial() {
        return nivelCombustibleInicial;
    }

    public void setNivelCombustibleInicial(double nivelCombustibleInicial) {
        this.nivelCombustibleInicial = nivelCombustibleInicial;
    }

    public EstadoAlquilerEnum getEstadoEstado() {
        return estado;
    }

    public void setEstado(EstadoAlquilerEnum estado) {
        this.estado = estado;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public int getKilometrajeFinal() {
        return kilometrajeFinal;
    }

    public void setKilometrajeFinal(int kilometrajeFinal) {
        this.kilometrajeFinal = kilometrajeFinal;
    }

    public double getNivelCombustibleFinal() {
        return nivelCombustibleFinal;
    }

    public void setNivelCombustibleFinal(double nivelCombustibleFinal) {
        this.nivelCombustibleFinal = nivelCombustibleFinal;
    }

    /**
     * Registra la devolución del vehículo con todos sus datos
     */
    public void registrarDevolucion(Date fechaDevolucion, int kilometrajeFinal, 
            double nivelCombustibleFinal, String estadoVehiculo, String observaciones) {
        this.fechaDevolucionReal = fechaDevolucion;
        this.kilometrajeFinal = kilometrajeFinal;
        this.nivelCombustibleFinal = nivelCombustibleFinal;
    }

    /**
     * Calcula cargos adicionales automáticamente según las reglas de negocio
     * Este método implementaría la lógica de cálculo de cargos adicionales
     * según el documento (devolución tardía, kilometraje extra, combustible, etc.)
     * La implementación completa se realizará en la capa de servicio
     */
    public void calcularCargosAdicionales() {
        // Esqueleto para implementación en la capa de servicio
    }

    /**
     * Verifica si el alquiler ya tiene devolución registrada
     */
    public boolean tieneDevolucion() {
        return this.fechaDevolucionReal != null;
    }

    /**
     * Inicia el alquiler cambiando su estado a VIGENTE y el estado del vehículo a ALQUILADO
     */
    public void iniciarAlquiler() {
        this.estado = EstadoAlquilerEnum.VIGENTE;
    }

    /**
     * Finaliza el alquiler cambiando su estado a FINALIZADO
     */
    public void finalizarAlquiler() {
        this.estado = EstadoAlquilerEnum.FINALIZADO;
    }

    /**
     * Cancela el alquiler
     */
    public void cancelarAlquiler() {
        this.estado = EstadoAlquilerEnum.CANCELADO;
    }

    /**
     * Verifica si el alquiler está vigente (activo)
     */
    public boolean estaActivo() {
        return this.estado == EstadoAlquilerEnum.VIGENTE;
    }

    /**
     * Calcula la duración en días del alquiler
     */
    public long calcularDuracionDias() {
        if (fechaInicio == null || fechaDevolucionReal == null) {
            return 0;
        }

        long diferencia = fechaDevolucionReal.getTime() - fechaInicio.getTime();

        return diferencia / (1000 * 60 * 60 * 24);
    }

    /**
     * Calcula los días de retraso en la devolución
     */
    public long calcularDiasRetraso() {
        if (fechaDevolucionReal == null || fechaDevolucionPrevista == null) {
            return 0;
        }
        
        if (fechaDevolucionReal.after(fechaDevolucionPrevista)) {
            long diferencia = fechaDevolucionReal.getTime() - fechaDevolucionPrevista.getTime();

            return diferencia / (1000 * 60 * 60 * 24);
        }

        return 0;
    }
}
