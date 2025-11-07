package alquilervehiculos.model.dto;

public class ListarVehiculosDisponiblesDTO {
    private int id;
    private String marca;
    private String modelo;
    private int anio;
    private double precioDiario;
    private String categoria;

    public ListarVehiculosDisponiblesDTO(int id, String marca, String modelo, int anio, double precioDiario, String categoria) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioDiario = precioDiario;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
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

    public double getPrecioDiario() {
        return precioDiario;
    }

    public String getCategoria() {
        return categoria;
    }
}
