package alquilervehiculos.model.entities;

import java.util.Date;

import alquilervehiculos.model.enums.RolUsuarioEnum;
import alquilervehiculos.model.enums.TurnoEmpleadoEnum;

public class Administrativo extends Empleado {
    private int idAdministrativo;
    private int metaAlquileresMensual;
    private int cantidadClientesAtendidos;
    private int cantidadIdiomas;

    public Administrativo(int metaAlquileresMensual, int cantidadIdiomas, double salario, TurnoEmpleadoEnum turno, String nombre, String apellido, String email, String dni, String telefono, String direccion, Date fechaNacimiento, String username, String password) {
        super(salario, turno, nombre, apellido, email, dni, telefono, direccion, fechaNacimiento, username, password, RolUsuarioEnum.ADMINISTRATIVO);

        this.metaAlquileresMensual = metaAlquileresMensual;
        this.cantidadClientesAtendidos = 0;
        this.cantidadIdiomas = cantidadIdiomas;
    }

    // Getters y Setters
    public int getIdAdministrativo() {
        return idAdministrativo;
    }

    public int getMetaAlquileresMensual() {
        return metaAlquileresMensual;
    }

    public void setMetaAlquileresMensual(int metaAlquileresMensual) {
        this.metaAlquileresMensual = metaAlquileresMensual;
    }

    public int getCantidadClientesAtendidos() {
        return cantidadClientesAtendidos;
    }

    public void setCantidadClientesAtendidos(int cantidadClientesAtendidos) {
        this.cantidadClientesAtendidos = cantidadClientesAtendidos;
    }

    public int getCantidadIdiomas() {
        return cantidadIdiomas;
    }

    public void setCantidadIdiomas(int cantidadIdiomas) {
        this.cantidadIdiomas = cantidadIdiomas;
    }
}
