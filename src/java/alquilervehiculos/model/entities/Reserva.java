package alquilervehiculos.model.entities;

import java.util.Date;

public class Reserva {
    private int idReserva;
    private Date fechaReserva;
    private int diasReserva;
    private double costoEstimado;

    public Reserva(int idReserva, Date fechaReserva, int diasReserva, double costoEstimado) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.diasReserva = diasReserva;
        this.costoEstimado = costoEstimado;
    }

    // TODO: getters, setters and methods needed.
}
