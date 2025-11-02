package alquilervehiculos.model.entities;

import java.util.Date;

public class Administrativo extends Empleado {
    private int idAdministrativo;
    private int metaAlquileresMensual;
    private int cantidadClientesAtendidos;
    private String idiomas;

    public Administrativo(int metaAlquileresMensual, String idiomas, String legajo, double salario, String nombre, String apellido, String email, String dni, String telefono, String direccion, Date fechaNacimiento) {
        super(legajo, salario, nombre, apellido, email, dni, telefono, direccion, fechaNacimiento);

        this.metaAlquileresMensual = metaAlquileresMensual;
        this.cantidadClientesAtendidos = 0;
        this.idiomas = idiomas;
    }

    // Getters y Setters
    public int getIdAdministrativo() {
        return idAdministrativo;
    }

    public void setIdAdministrativo(int idAdministrativo) {
        this.idAdministrativo = idAdministrativo;
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

    public String getIdiomas() {
        return idiomas;
    }

    public void setCantidadIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }
}
