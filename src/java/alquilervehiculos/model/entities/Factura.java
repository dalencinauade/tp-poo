package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.EstadoFacturaEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {
    private int idFactura;
    private Date fechaEmision;
    private double subtotal;
    private double impuestos;
    private double total;
    private EstadoFacturaEnum estado;
    private Alquiler alquiler; // Relación 1:1 con Alquiler
    private List<DetalleFactura> detalles; // Relación 1:N con DetalleFactura

    public Factura(int idFactura, Date fechaEmision, double subtotal,
            double impuestos, double total, EstadoFacturaEnum estado, Alquiler alquiler) {
        this.idFactura = idFactura;
        this.fechaEmision = fechaEmision;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
        this.total = total;
        this.estado = estado;
        this.alquiler = alquiler;
        this.detalles = new ArrayList<>();
    }

    // Getters y Setters
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
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

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    public void agregarDetalle(DetalleFactura detalle) {
        this.detalles.add(detalle);
    }

    public void recalcularTotales() {
        this.subtotal = detalles.stream()
                .mapToDouble(DetalleFactura::getSubtotal)
                .sum();
        this.total = this.subtotal + this.impuestos;
    }
}
