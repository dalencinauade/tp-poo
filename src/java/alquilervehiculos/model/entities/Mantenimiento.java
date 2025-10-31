package alquilervehiculos.model.entities;

import java.util.Date;

import alquilervehiculos.model.enums.EstadoMantenimientoEnum;
import alquilervehiculos.model.enums.TipoMantenimientoEnum;

public class Mantenimiento {
    private int idMantenimiento;
    private Date fechaInicio;
    private Date fechaFin;
    private TipoMantenimientoEnum tipo;
    private String descripcion;
    private double costo;
    private EstadoMantenimientoEnum estado;

    public Mantenimiento(Date fechaInicio, Date fechaFin, TipoMantenimientoEnum tipo, String descripcion, double costo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.estado = EstadoMantenimientoEnum.EN_PROCESO;
    }

    // Getters y Setters
    public int getIdMantenimiento() {
        return idMantenimiento;
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

    public TipoMantenimientoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoMantenimientoEnum tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public EstadoMantenimientoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoMantenimientoEnum estado) {
        this.estado = estado;
    }

    // Métodos de negocio
    
    /**
     * Inicia el mantenimiento
     */
    public void iniciar() {
        this.estado = EstadoMantenimientoEnum.EN_PROCESO;
        if (this.fechaInicio == null) {
            this.fechaInicio = new Date();
        }
    }

    /**
     * Finaliza el mantenimiento
     */
    public void finalizar() {
        this.estado = EstadoMantenimientoEnum.COMPLETADO;
        if (this.fechaFin == null) {
            this.fechaFin = new Date();
        }
    }

    /**
     * Verifica si el mantenimiento está completado
     */
    public boolean estaCompletado() {
        return this.estado == EstadoMantenimientoEnum.COMPLETADO;
    }

    /**
     * Verifica si el mantenimiento está en proceso
     */
    public boolean estaEnProceso() {
        return this.estado == EstadoMantenimientoEnum.EN_PROCESO;
    }

    /**
     * Verifica si es un mantenimiento preventivo
     */
    public boolean esPreventivo() {
        return this.tipo == TipoMantenimientoEnum.PREVENTIVO;
    }

    /**
     * Calcula la duración del mantenimiento en horas
     */
    public long calcularDuracionHoras() {
        if (fechaInicio == null || fechaFin == null) {
            return 0;
        }
        long diferencia = fechaFin.getTime() - fechaInicio.getTime();
        return diferencia / (1000 * 60 * 60);
    }
}
