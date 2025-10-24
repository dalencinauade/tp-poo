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

    // TODO: getter, setters y methods needed.

}
