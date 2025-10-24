package alquilervehiculos.model.entities;

import alquilervehiculos.model.enums.PuestoAdministrativoEnum;

public class Administrativo {
    private int idAdministrativo;
    private PuestoAdministrativoEnum puesto;
    private int metaAlquileresMensual;
    private int cantidadClientesAtendidos;
    private int cantidadIdiomas;

    public Administrativo(int id, PuestoAdministrativoEnum puesto, int metaAlquileresMensual, int cantClientesAtendidos,
            int cantIdiomas) {
        this.idAdministrativo = id;
        this.puesto = puesto;
        this.metaAlquileresMensual = metaAlquileresMensual;
        this.cantidadClientesAtendidos = cantClientesAtendidos;
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
