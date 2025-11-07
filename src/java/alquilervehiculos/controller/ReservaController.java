package alquilervehiculos.controller;

import java.util.Date;

import alquilervehiculos.model.entities.Reserva;
import alquilervehiculos.model.entities.Respuesta;
import alquilervehiculos.service.ReservaService;

public class ReservaController {
    private ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    public Respuesta confirmar(int idVehiculo, int idUsuario, Date desde, Date hasta, double costoEstimado) {
        boolean exito = false;
        String mensaje = "";

        try {
            Reserva reserva = new Reserva(desde, hasta, costoEstimado);

            exito = reservaService.confirmar(idVehiculo, idUsuario, reserva);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return new Respuesta(exito, mensaje);
    }
}
