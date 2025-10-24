package alquilervehiculos.model.entities;

import java.util.Date;
import java.util.List;

import alquilervehiculos.model.enums.EspecialidadTecnicoEnum;

public class Tecnico {
    private int idTecnico;
    private EspecialidadTecnicoEnum especialidad;
    private List<String> certificaciones;
    private Date fechaInicioComoTecnico;

    public Tecnico(int idTecnico, EspecialidadTecnicoEnum especialidad, List<String> certificaciones,
            Date fechaInicioComoTecnico) {
        this.idTecnico = idTecnico;
        this.especialidad = especialidad;
        this.certificaciones = certificaciones;
        this.fechaInicioComoTecnico = fechaInicioComoTecnico;
    }

    // Getters y Setters
    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public EspecialidadTecnicoEnum getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadTecnicoEnum especialidad) {
        this.especialidad = especialidad;
    }

    public List<String> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(List<String> certificaciones) {
        this.certificaciones = certificaciones;
    }

    public Date getFechaInicioComoTecnico() {
        return fechaInicioComoTecnico;
    }

    public void setFechaInicioComoTecnico(Date fechaInicioComoTecnico) {
        this.fechaInicioComoTecnico = fechaInicioComoTecnico;
    }
}
