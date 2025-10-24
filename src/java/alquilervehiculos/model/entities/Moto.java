package alquilervehiculos.model.entities;

public class Moto {
    private int idMoto;
    private int cantidadPasajeros;
    private boolean tieneSidecar;
    private int cilindrada;

    public Moto(int idMoto, int cantidadPasajeros, boolean tieneSidecar, int cilindrada) {
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
