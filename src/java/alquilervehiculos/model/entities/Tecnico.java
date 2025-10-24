package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.EspecialidadTecnicoEnum;
import java.util.Date;
import java.util.List;

public class Tecnico extends Empleado {
    private int idTecnico;
    private EspecialidadTecnicoEnum especialidad;
    private List<String> certificaciones;
    private Date fechaInicioComoTecnico;

    public Tecnico(int dni, String nombre, String apellido, String email,
            String legajo, int idTecnico, EspecialidadTecnicoEnum especialidad, List<String> certificaciones,
            Date fechaInicioComoTecnico) {
        super(dni, nombre, apellido, email, legajo);
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
