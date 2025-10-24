package alquilervehiculos.model.entities;

import java.util.Date;

import alquilervehiculos.model.enums.EstadoAlquilerEnum;

public class Alquiler {
    private int idAlquiler;
    private Date fechaAlquiler;
    private Date fechaDevolucionPrevista;
    private int kilometrajeInicial;
    private double nivelCombustibleInicial;
    private EstadoAlquilerEnum estadoAlquiler;

    public Alquiler(int id, Date fechaAlquiler, Date fechaDevolucionPrevista, int kilometrajeInicial,
            double nivelCombustibleInicial, EstadoAlquilerEnum estadoAlquiler) {
        this.idAlquiler = id;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
        this.kilometrajeInicial = kilometrajeInicial;
        this.nivelCombustibleInicial = nivelCombustibleInicial;
        this.estadoAlquiler = estadoAlquiler;
    }

    // Getters y Setters
    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Date getFechaDevolucionPrevista() {
        return fechaDevolucionPrevista;
    }

    public void setFechaDevolucionPrevista(Date fechaDevolucionPrevista) {
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
    }

    public int getKilometrajeInicial() {
        return kilometrajeInicial;
    }

    public void setKilometrajeInicial(int kilometrajeInicial) {
        this.kilometrajeInicial = kilometrajeInicial;
    }

    public double getNivelCombustibleInicial() {
        return nivelCombustibleInicial;
    }

    public void setNivelCombustibleInicial(double nivelCombustibleInicial) {
        this.nivelCombustibleInicial = nivelCombustibleInicial;
    }

    public EstadoAlquilerEnum getEstadoAlquiler() {
        return estadoAlquiler;
    }

    public void setEstadoAlquiler(EstadoAlquilerEnum estadoAlquiler) {
        this.estadoAlquiler = estadoAlquiler;
    }
}
