package alquilervehiculos.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import alquilervehiculos.model.enums.EstadoFacturaEnum;

public class Factura {
    private int idFactura;
    private Date fecha;
    private double subtotal;
    private double total;
    private EstadoFacturaEnum estado;
    private Alquiler alquiler; // Relación 1:1 con Alquiler
    private List<DetalleFactura> detalles; // Relación 1:N con DetalleFactura

    public Factura(Date fecha, double subtotal, double total, Alquiler alquiler) {
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = total;
        this.estado = EstadoFacturaEnum.EMITIDA;
        this.alquiler = alquiler;
        this.detalles = new ArrayList<>();
    }

    // Getters y Setters
    public int getIdFactura() {
        return idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
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
        this.total = this.subtotal + (this.subtotal * 0.21);
    }

    /**
     * Calcula los impuestos basado en el subtotal (21% IVA por defecto)
     */
    public void calcularImpuestos() {
        this.total = this.subtotal + (this.subtotal * 0.21);
    }

    /**
     * Marca la factura como pagada
     */
    public void marcarComoPagada() {
        this.estado = EstadoFacturaEnum.PAGADA;
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
    public boolean estaEmitida() {
        return this.estado == EstadoFacturaEnum.EMITIDA;
    }

    /**
     * Genera el texto de la factura para impresión
     */
    public String generarTextoFactura() {
        StringBuilder texto = new StringBuilder();
        texto.append("=== FACTURA ===\n");
        texto.append("ID: ").append(idFactura).append("\n");
        texto.append("Fecha Emisión: ").append(fecha).append("\n\n");
        texto.append("DETALLES:\n");
        for (DetalleFactura detalle : detalles) {
            texto.append("- ").append(detalle.getConcepto())
                 .append(" x").append(detalle.getCantidad())
                 .append(" = $").append(detalle.getSubtotal()).append("\n");
        }
        texto.append("\nSubtotal: $").append(subtotal).append("\n");
        texto.append("Impuestos (21%): $").append((this.subtotal * 0.21)).append("\n");
        texto.append("TOTAL: $").append(total).append("\n");
        texto.append("\nEstado: ").append(estado).append("\n");
        return texto.toString();
    }
}
