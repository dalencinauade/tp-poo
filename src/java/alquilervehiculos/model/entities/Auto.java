package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.CategoriaVehiculoEnum;
import alquilervehiculos.model.enums.EstadoVehiculoEnum;

public class Auto extends Vehiculo {
    private int numeroPuertas;
    private double capacidadBaul;

    public Auto(int idVehiculo, String patente, String marca, String modelo, int anio,
            double precioDiario, double capacidadTanque, CategoriaVehiculoEnum categoria, EstadoVehiculoEnum estado,
            int numeroPuertas, double capacidadBaul) {
        super(idVehiculo, patente, marca, modelo, anio, precioDiario,
                capacidadTanque, categoria, estado);
        this.numeroPuertas = numeroPuertas;
        this.capacidadBaul = capacidadBaul;
    }

    // Getters y Setters
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public double getCapacidadBaul() {
        return capacidadBaul;
    }

    public void setCapacidadBaul(double capacidadBaul) {
        this.capacidadBaul = capacidadBaul;
    }
}
