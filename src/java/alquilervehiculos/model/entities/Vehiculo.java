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
            double precioDiario, double capacidadTanque, CategoriaVehiculoEnum categoria, EstadoVehiculoEnum estado) {
        this.idVehiculo = idVehiculo;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioDiario = precioDiario;
        this.capacidadTanque = capacidadTanque;
        this.categoria = categoria;
        this.estado = estado;
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
}
