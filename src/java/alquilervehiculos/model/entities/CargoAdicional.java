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

    // TODO: getters, setters and methods needed.
}
