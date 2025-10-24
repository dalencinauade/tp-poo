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

    /**
     * Calcula los impuestos basado en el subtotal (21% IVA por defecto)
     */
    public void calcularImpuestos() {
        this.impuestos = this.subtotal * 0.21;
        this.total = this.subtotal + this.impuestos;
    }

    /**
     * Marca la factura como pagada
     */
    public void marcarComoPagada() {
        this.estado = EstadoFacturaEnum.PAGADA;
    }

    /**
     * Marca la factura como pendiente
     */
    public void marcarComoPendiente() {
        this.estado = EstadoFacturaEnum.PENDIENTE;
    }

    /**
     * Anula la factura
     */
    public void anular() {
        this.estado = EstadoFacturaEnum.ANULADA;
    }

    /**
     * Verifica si la factura está pagada
     */
    public boolean estaPagada() {
        return this.estado == EstadoFacturaEnum.PAGADA;
    }

    /**
     * Verifica si la factura está pendiente
     */
    public boolean estaPendiente() {
        return this.estado == EstadoFacturaEnum.PENDIENTE;
    }

    /**
     * Genera el texto de la factura para impresión
     */
    public String generarTextoFactura() {
        StringBuilder texto = new StringBuilder();
        texto.append("=== FACTURA ===\n");
        texto.append("ID: ").append(idFactura).append("\n");
        texto.append("Fecha Emisión: ").append(fechaEmision).append("\n\n");
        texto.append("DETALLES:\n");
        for (DetalleFactura detalle : detalles) {
            texto.append("- ").append(detalle.getConcepto())
                 .append(" x").append(detalle.getCantidad())
                 .append(" = $").append(detalle.getSubtotal()).append("\n");
        }
        texto.append("\nSubtotal: $").append(subtotal).append("\n");
        texto.append("Impuestos (21%): $").append(impuestos).append("\n");
        texto.append("TOTAL: $").append(total).append("\n");
        texto.append("\nEstado: ").append(estado).append("\n");
        return texto.toString();
    }
}
