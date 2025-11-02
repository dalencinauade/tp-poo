package alquilervehiculos.model.entities;

import java.util.Date;

public class Tecnico extends Empleado {
    private int idTecnico;
    private int cantidadRevisiones;

    public Tecnico(String legajo, double salario, String nombre, String apellido, String email, String dni, String telefono, String direccion, Date fechaNacimiento) {
        super(legajo, salario, nombre, apellido, email, dni, telefono, direccion, fechaNacimiento);
        
        this.cantidadRevisiones = 0;
    }

    // Getters y Setters
    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public int getCantidadRevisiones() {
        return cantidadRevisiones;
    }
    
    public void setCantidadRevisiones() {
        this.cantidadRevisiones++;
    }
}
