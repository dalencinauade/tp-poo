package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.MetodoPagoEnum;

public class Pago {
    private int idPago;
    private MetodoPagoEnum metodoPago;

    public Pago(int idPago, MetodoPagoEnum metodoPago) {
        this.idPago = idPago;
        this.metodoPago = metodoPago;
    }

    // TODO: getters, setters and methods needed.
}
