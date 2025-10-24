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

    public Mantenimiento(int idMantenimiento, Date fechaInicio, Date fechaFin, TipoMantenimientoEnum tipo,
            String descripcion, double costo,
            EstadoMantenimientoEnum estado) {
        this.idMantenimiento = idMantenimiento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.estado = estado;
    }

    // TODO: getters, setters and methods needed.
}
