package alquilervehiculos.model.entities;

import java.util.Date;

import alquilervehiculos.model.enums.RolUsuarioEnum;
import alquilervehiculos.model.enums.TurnoEmpleadoEnum;

public class Tecnico extends Empleado {
    private int idTecnico;
    private int cantidadRevisiones;

    public Tecnico(double salario, TurnoEmpleadoEnum turno, String nombre, String apellido, String email, String dni, String telefono, String direccion, Date fechaNacimiento, String username, String password) {
        super(salario, turno, nombre, apellido, email, dni, telefono, direccion, fechaNacimiento, username, password, RolUsuarioEnum.TECNICO);
        
        this.cantidadRevisiones = 0;
    }

    // Getters y Setters
    public int getIdTecnico() {
        return idTecnico;
    }

    public int getCantidadRevisiones() {
        return cantidadRevisiones;
    }
    
    public void setCantidadRevisiones() {
        this.cantidadRevisiones++;
    }
}
