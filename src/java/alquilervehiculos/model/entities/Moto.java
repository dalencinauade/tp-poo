package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.CategoriaVehiculoEnum;
import alquilervehiculos.model.enums.EstadoVehiculoEnum;

public class Moto extends Vehiculo {
    private int idMoto;
    private int cantidadPasajeros;
    private boolean tieneSidecar;
    private int cilindrada;

    public Moto(int idVehiculo, String patente, String marca, String modelo, int anio,
            double precioDiario, double capacidadTanque, CategoriaVehiculoEnum categoria, EstadoVehiculoEnum estado,
            int idMoto, int cantidadPasajeros, boolean tieneSidecar, int cilindrada) {
        super(idVehiculo, patente, marca, modelo, anio, precioDiario,
                capacidadTanque, categoria, estado);
        this.idMoto = idMoto;
        this.cantidadPasajeros = cantidadPasajeros;
        this.tieneSidecar = tieneSidecar;
        this.cilindrada = cilindrada;
    }

    // Getters y Setters
    public int getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(int idMoto) {
        this.idMoto = idMoto;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    public void setTieneSidecar(boolean tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}
