package alquilervehiculos.model.entities;

import java.util.Date;

public class Contrato {
    private int idContrato;
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaDevolucionReal;
    private double costoEstimado;
    private double costoTotal;
    private String terminosCondiciones;
    private String firmaCliente;

    public Contrato(int idContrato, Date fechaInicio, Date fechaFin, Date fechaDevolucionReal, double costoEstimado,
            double costoTotal, String terminosCondiciones, String firmaCliente) {
        this.idContrato = idContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.costoEstimado = costoEstimado;
        this.costoTotal = costoTotal;
        this.terminosCondiciones = terminosCondiciones;
        this.firmaCliente = firmaCliente;
    }

    // TODO: getters, setters and methods needed.
}
