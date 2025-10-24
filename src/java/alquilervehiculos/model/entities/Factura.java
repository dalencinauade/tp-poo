package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.EstadoFacturaEnum;

public class Factura {
    private int idFactura;
    private double subtotal;
    private double impuestos;
    private double total;
    private EstadoFacturaEnum estado;

    public Factura(int idFactura, double subtotal, double impuestos, double total, EstadoFacturaEnum estado) {
        this.idFactura = idFactura;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
        this.total = total;
        this.estado = estado;
    }

    // TODO: getters, setters and methods needed.
}
