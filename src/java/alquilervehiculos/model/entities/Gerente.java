package alquilervehiculos.model.entities;

import java.util.Date;

public class Gerente {
    private int idGerente;
    private double bonoRendimiento;
    private Date fechaInicioComoGerente;
    private double metaVentasMensual;

    public Gerente(int id, double bonoRendimiento, Date fechaInicioComoGerente, double metaVentasMensual) {
        this.idGerente = id;
        this.bonoRendimiento = bonoRendimiento;
        this.fechaInicioComoGerente = fechaInicioComoGerente;
        this.metaVentasMensual = metaVentasMensual;
    }

    // TODO: getters, setters and methods needed.
}
