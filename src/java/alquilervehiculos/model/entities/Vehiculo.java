package alquilervehiculos.model.entities;

public class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private int anio;
    private double precioDiario;
    private double capacidadTanque;

    public Vehiculo(String patente, String marca, String modelo, int anio, double precioDiario,
            double capacidadTanque) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioDiario = precioDiario;
        this.capacidadTanque = capacidadTanque;
    }

    // TODO: getters, setters and methods needed.
}
