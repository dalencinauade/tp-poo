package alquilervehiculos.model.dto;

public class ObtenerVehiculoParaEdicionDTO {
    private String patente;
    private String marca;
    private String modelo;
    private int anio;
    private double precioDiario;
    private double capacidadTanque;
    private double capacidadTanqueMaxima;
    private int kilometraje;
    private String categoria;
    private String estado;

    // Getters y Setters
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecioDiario() {
        return precioDiario;
    }

    public void setPrecioDiario(double precioDiario) {
        this.precioDiario = precioDiario;
    }

    public double getCapacidadTanque() {
        return capacidadTanque;
    }

    public void setCapacidadTanque(double capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }

    public double getCapacidadTanqueMaxima() {
        return capacidadTanqueMaxima;
    }

    public void setCapacidadTanqueMaxima(double capacidadTanqueMaxima) {
        this.capacidadTanqueMaxima = capacidadTanqueMaxima;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
