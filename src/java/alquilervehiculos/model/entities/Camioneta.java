package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.CategoriaVehiculoEnum;
import alquilervehiculos.model.enums.EstadoVehiculoEnum;

public class Camioneta extends Vehiculo {
    private double capacidadCarga;
    private boolean esTodoTerreno;

    public Camioneta(int idVehiculo, String patente, String marca, String modelo, int anio,
            double precioDiario, double capacidadTanque, CategoriaVehiculoEnum categoria,
            EstadoVehiculoEnum estado, double capacidadCarga, boolean esTodoTerreno) {
        super(idVehiculo, patente, marca, modelo, anio, precioDiario,
                capacidadTanque, categoria, estado);
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
