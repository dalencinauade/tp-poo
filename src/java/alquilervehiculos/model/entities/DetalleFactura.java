package alquilervehiculos.model.entities;

public class DetalleFactura {
    private int idDetalle;
    private String concepto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public DetalleFactura(int idDetalle, String concepto, int cantidad, double precioUnitario) {
        this.idDetalle = idDetalle;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
}
