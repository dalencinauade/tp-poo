package alquilervehiculos.model.entities;

public class DetalleFactura {
    private int idDetalle;
    private String concepto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public DetalleFactura(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    // Getters y Setters
    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Calcula el subtotal automáticamente basado en cantidad y precio unitario
     */
    public void calcularSubtotal() {
        this.subtotal = this.cantidad * this.precioUnitario;
    }
}
