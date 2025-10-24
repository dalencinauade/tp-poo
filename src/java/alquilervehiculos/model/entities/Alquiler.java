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

    // TODO: getters, setters and methods needed.
}
