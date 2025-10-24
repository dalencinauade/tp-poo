package alquilervehiculos.model.entities;

import java.util.Date;

import alquilervehiculos.model.enums.TipoReporteEnum;

public class Reporte {
    private int idReporte;
    private TipoReporteEnum tipoReporte;
    private Date fechaGeneracion;
    private Date fechaInicio;
    private Date fechaFin;

    public Reporte(int idReporte, TipoReporteEnum tipoReporte, Date fechaGeneracion, Date fechaInicio, Date fechaFin) {
        this.idReporte = idReporte;
        this.tipoReporte = tipoReporte;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // TODO: getters, setters and methods needed.
}
