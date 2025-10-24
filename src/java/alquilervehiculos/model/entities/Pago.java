package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.MetodoPagoEnum;

public class Pago {
    private int idPago;
    private MetodoPagoEnum metodoPago;

    public Pago(int idPago, MetodoPagoEnum metodoPago) {
        this.idPago = idPago;
        this.metodoPago = metodoPago;
    }

    // Getters y Setters
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public MetodoPagoEnum getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPagoEnum metodoPago) {
        this.metodoPago = metodoPago;
    }

    // Métodos de negocio
    
    /**
     * Valida si el método de pago es válido
     */
    public boolean validarMetodoPago() {
        return this.metodoPago != null;
    }

    /**
     * Verifica si el pago es con efectivo
     */
    public boolean esEfectivo() {
        return this.metodoPago == MetodoPagoEnum.EFECTIVO;
    }

    /**
     * Verifica si el pago es con tarjeta
     */
    public boolean esConTarjeta() {
        return this.metodoPago == MetodoPagoEnum.TARJETA_CREDITO || 
               this.metodoPago == MetodoPagoEnum.TARJETA_DEBITO;
    }
}
