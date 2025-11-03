package alquilervehiculos.model.dto;

public class ListarVehiculosDTO {
    private int id;
    private String patente;
    private String marca;
    private String modelo;
    private int anio;
    private int kilometraje;
    private String categoria;
    private String estado;

    public ListarVehiculosDTO(int id, String patente, String marca, String modelo, int anio, int kilometraje, String categoria, String estado) {
        this.id = id;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.kilometraje = kilometraje;
        this.categoria = categoria;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEstado() {
        return estado;
    }
}
