package alquilervehiculos.model.entities;

public class Auto {
    private int numeroPuertas;
    private double capacidadBaul;
    
    public Auto(int numeroPuertas, double capacidadBaul) {
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
