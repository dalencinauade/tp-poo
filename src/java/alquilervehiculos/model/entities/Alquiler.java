package alquilervehiculos.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import alquilervehiculos.model.enums.EstadoAlquilerEnum;

public class Alquiler {
    private int idAlquiler;
    private Date fechaAlquiler;
    private Date fechaDevolucionPrevista;
    private int kilometrajeInicial;
    private double nivelCombustibleInicial;
    private EstadoAlquilerEnum estadoAlquiler;
    private Cliente cliente; // Relación N:1 con Cliente
    private Vehiculo vehiculo; // Relación N:1 con Vehiculo
    private Contrato contrato; // Relación 1:1 con Contrato
    private Factura factura; // Relación 1:1 con Factura
    
    // Atributos de devolución
    private Date fechaDevolucionReal;
    private int kilometrajeFinal;
    private double nivelCombustibleFinal;
    private String estadoVehiculo;
    private String observaciones;
    private List<CargoAdicional> cargosAdicionales; // Relación 1:N con CargoAdicional

    public Alquiler(int id, Date fechaAlquiler, Date fechaDevolucionPrevista, int kilometrajeInicial,
            double nivelCombustibleInicial, EstadoAlquilerEnum estadoAlquiler,
            Cliente cliente, Vehiculo vehiculo) {
        this.idAlquiler = id;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
        this.kilometrajeInicial = kilometrajeInicial;
        this.nivelCombustibleInicial = nivelCombustibleInicial;
        this.estadoAlquiler = estadoAlquiler;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.cargosAdicionales = new ArrayList<>();
    }

    // Getters y Setters
    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Date getFechaDevolucionPrevista() {
        return fechaDevolucionPrevista;
    }

    public void setFechaDevolucionPrevista(Date fechaDevolucionPrevista) {
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
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

    public EstadoAlquilerEnum getEstadoAlquiler() {
        return estadoAlquiler;
    }

    public void setEstadoAlquiler(EstadoAlquilerEnum estadoAlquiler) {
        this.estadoAlquiler = estadoAlquiler;
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

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Date getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(Date fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
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

    public String getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(String estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<CargoAdicional> getCargosAdicionales() {
        return cargosAdicionales;
    }

    public void setCargosAdicionales(List<CargoAdicional> cargosAdicionales) {
        this.cargosAdicionales = cargosAdicionales;
    }

    /**
     * Agrega un cargo adicional al alquiler
     */
    public void agregarCargo(CargoAdicional cargo) {
        this.cargosAdicionales.add(cargo);
    }

    /**
     * Registra la devolución del vehículo con todos sus datos
     */
    public void registrarDevolucion(Date fechaDevolucion, int kilometrajeFinal, 
            double nivelCombustibleFinal, String estadoVehiculo, String observaciones) {
        this.fechaDevolucionReal = fechaDevolucion;
        this.kilometrajeFinal = kilometrajeFinal;
        this.nivelCombustibleFinal = nivelCombustibleFinal;
        this.estadoVehiculo = estadoVehiculo;
        this.observaciones = observaciones;
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
}
