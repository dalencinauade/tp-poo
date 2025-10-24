package alquilervehiculos.model.entities;

public class Camioneta {
    private double capacidadCarga;
    private boolean esTodoTerreno;

    public Camioneta(double capacidadCarga, boolean esTodoTerreno) {
        this.capacidadCarga = capacidadCarga;
        this.esTodoTerreno = esTodoTerreno;
    }

    // Getters y Setters
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public boolean isEsTodoTerreno() {
        return esTodoTerreno;
    }

    public void setEsTodoTerreno(boolean esTodoTerreno) {
        this.esTodoTerreno = esTodoTerreno;
    }
}
