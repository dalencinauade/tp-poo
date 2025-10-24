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

    // TODO: getters, setters and methods needed.
}
