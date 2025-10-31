package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.CategoriaVehiculoEnum;
import alquilervehiculos.model.enums.EstadoVehiculoEnum;

public abstract class Vehiculo {
    private int idVehiculo;
    private String patente;
    private String marca;
    private String modelo;
    private int anio;
    private double precioDiario;
    private double capacidadTanque;
    private CategoriaVehiculoEnum categoria;
    private EstadoVehiculoEnum estado;

    public Vehiculo(int idVehiculo, String patente, String marca, String modelo, int anio,
            double precioDiario, double capacidadTanque, CategoriaVehiculoEnum categoria) {
        this.idVehiculo = idVehiculo;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioDiario = precioDiario;
        this.capacidadTanque = capacidadTanque;
        this.categoria = categoria;
        this.estado = EstadoVehiculoEnum.DISPONIBLE;
    }

    // Getters y Setters
    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecioDiario() {
        return precioDiario;
    }

    public void setPrecioDiario(double precioDiario) {
        this.precioDiario = precioDiario;
    }

    public double getCapacidadTanque() {
        return capacidadTanque;
    }

    public void setCapacidadTanque(double capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }

    public CategoriaVehiculoEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaVehiculoEnum categoria) {
        this.categoria = categoria;
    }

    public EstadoVehiculoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculoEnum estado) {
        this.estado = estado;
    }

    // Métodos de negocio
    
    /**
     * Verifica si el vehículo está disponible para alquiler
     */
    public boolean estaDisponible() {
        return this.estado == EstadoVehiculoEnum.DISPONIBLE;
    }

    /**
     * Verifica si el vehículo está alquilado
     */
    public boolean estaAlquilado() {
        return this.estado == EstadoVehiculoEnum.ALQUILADO;
    }

    /**
     * Verifica si el vehículo está en mantenimiento
     */
    public boolean estaEnMantenimiento() {
        return this.estado == EstadoVehiculoEnum.MANTENIMIENTO;
    }

    /**
     * Marca el vehículo como disponible
     */
    public void marcarComoDisponible() {
        this.estado = EstadoVehiculoEnum.DISPONIBLE;
    }

    /**
     * Marca el vehículo como alquilado
     */
    public void marcarComoAlquilado() {
        this.estado = EstadoVehiculoEnum.ALQUILADO;
    }

    /**
     * Marca el vehículo como en mantenimiento
     */
    public void marcarComoEnMantenimiento() {
        this.estado = EstadoVehiculoEnum.MANTENIMIENTO;
    }

    /**
     * Calcula la edad del vehículo en años
     */
    public int calcularEdad() {
        return java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - this.anio;
    }
}
