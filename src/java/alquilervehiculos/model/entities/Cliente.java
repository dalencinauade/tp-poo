package alquilervehiculos.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Persona {
    private int idCliente;
    private String numeroLicencia;
    private Date fechaVencimientoLicencia;
    private String tipoLicencia;
    private List<Alquiler> historialAlquileres;

    public Cliente(int dni, String telefono, String direccion, int idCliente, String numeroLicencia,
            Date fechaVencimientoLicencia, String tipoLicencia) {
        super(dni, telefono, direccion);
        this.idCliente = idCliente;
        this.numeroLicencia = numeroLicencia;
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
        this.tipoLicencia = tipoLicencia;
        this.historialAlquileres = new ArrayList<>();
    }

    // TODO: getters, setters and methods needed.
}
