package alquilervehiculos.model.entities;

import java.util.Date;

import alquilervehiculos.model.enums.TipoReporteEnum;

public class Reporte {
    private int idReporte;
    private TipoReporteEnum tipoReporte;
    private Date fechaGeneracion;
    private Date fechaInicio;
    private Date fechaFin;

    public Reporte(TipoReporteEnum tipoReporte, Date fechaGeneracion, Date fechaInicio, Date fechaFin) {
        this.tipoReporte = tipoReporte;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y Setters
    public int getIdReporte() {
        return idReporte;
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

    // Métodos de negocio
    
    /**
     * Genera el reporte (método a implementar en service)
     */
    public String generar() {
        // Este método será implementado en la capa de servicio
        return "Reporte generado: " + this.tipoReporte;
    }

    /**
     * Exporta el reporte a PDF (método a implementar en service)
     */
    public void exportarPDF() {
        // Implementación en capa de servicio
    }

    /**
     * Exporta el reporte a Excel (método a implementar en service)
     */
    public void exportarExcel() {
        // Implementación en capa de servicio
    }

    /**
     * Verifica si es un reporte de disponibilidad de vehículos
     */
    public boolean esReporteDisponibilidad() {
        return this.tipoReporte == TipoReporteEnum.DISPONIBILIDAD_VEHICULOS;
    }

    /**
     * Verifica si es un reporte de ingresos
     */
    public boolean esReporteIngresos() {
        return this.tipoReporte == TipoReporteEnum.INGRESOS_ALQUILER;
    }

    /**
     * Calcula la cantidad de días del período del reporte
     */
    public long calcularDiasPeriodo() {
        if (fechaInicio == null || fechaFin == null) {
            return 0;
        }
        long diferencia = fechaFin.getTime() - fechaInicio.getTime();
        return diferencia / (1000 * 60 * 60 * 24);
    }
}
