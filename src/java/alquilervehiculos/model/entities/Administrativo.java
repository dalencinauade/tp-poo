package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.PuestoAdministrativoEnum;

public class Administrativo extends Empleado {
    private int idAdministrativo;
    private PuestoAdministrativoEnum puesto;
    private int metaAlquileresMensual;
    private int cantidadClientesAtendidos;
    private int cantidadIdiomas;

    public Administrativo(int dni, String nombre, String apellido, String email,
            String legajo, int idAdministrativo, PuestoAdministrativoEnum puesto, int metaAlquileresMensual,
            int cantIdiomas) {
        super(dni, nombre, apellido, email, legajo);
        this.idAdministrativo = idAdministrativo;
        this.puesto = puesto;
        this.metaAlquileresMensual = metaAlquileresMensual;
        this.cantidadClientesAtendidos = 0;
        this.cantidadIdiomas = cantIdiomas;
    }

    // Getters y Setters
    public int getIdAdministrativo() {
        return idAdministrativo;
    }

    public void setIdAdministrativo(int idAdministrativo) {
        this.idAdministrativo = idAdministrativo;
    }

    public PuestoAdministrativoEnum getPuesto() {
        return puesto;
    }

    public void setPuesto(PuestoAdministrativoEnum puesto) {
        this.puesto = puesto;
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
