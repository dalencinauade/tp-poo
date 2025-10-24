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

    // Getters y Setters
    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public TipoReporteEnum getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(TipoReporteEnum tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
