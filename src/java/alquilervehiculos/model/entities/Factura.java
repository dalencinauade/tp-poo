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

    // Getters y Setters
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public EstadoFacturaEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoFacturaEnum estado) {
        this.estado = estado;
    }
}
