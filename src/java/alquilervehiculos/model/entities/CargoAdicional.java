package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.TipoCargoEnum;

public class CargoAdicional {
    private int idCargo;
    private TipoCargoEnum tipo;
    private String descripcion;
    private double monto;

    public CargoAdicional(TipoCargoEnum tipo, String descripcion, double monto) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    // Getters y Setters
    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public TipoCargoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoCargoEnum tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    // Métodos de negocio
    
    /**
     * Verifica si es un cargo por devolución tardía
     */
    public boolean esDevolucionTardia() {
        return this.tipo == TipoCargoEnum.DEVOLUCION_TARDIA;
    }

    /**
     * Verifica si es un cargo por kilometraje extra
     */
    public boolean esKilometrajeExtra() {
        return this.tipo == TipoCargoEnum.KILOMETRAJE_EXTRA;
    }

    /**
     * Verifica si es un cargo por daño al vehículo
     */
    public boolean esDanioVehiculo() {
        return this.tipo == TipoCargoEnum.DANIO_VEHICULO;
    }

    /**
     * Verifica si es un cargo por combustible
     */
    public boolean esFaltaCombustible() {
        return this.tipo == TipoCargoEnum.FALTA_COMBUSTIBLE;
    }

    /**
     * Genera un resumen del cargo
     */
    public String generarResumen() {
        return String.format("Cargo: %s - %s - $%.2f", tipo, descripcion, monto);
    }
}
