package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.TipoCargoEnum;

public class CargoAdicional {
    private int idCargo;
    private TipoCargoEnum tipo;
    private String descripcion;
    private double monto;

    public CargoAdicional(int idCargo, TipoCargoEnum tipo, String descripcion, double monto) {
        this.idCargo = idCargo;
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
}
