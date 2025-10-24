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

    public Cliente(int dni, String nombre, String apellido, String email,
            int idCliente, String numeroLicencia, Date fechaVencimientoLicencia, String tipoLicencia) {
        super(dni, nombre, apellido, email);
        this.idCliente = idCliente;
        this.numeroLicencia = numeroLicencia;
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
        this.tipoLicencia = tipoLicencia;
        this.historialAlquileres = new ArrayList<>();
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Date getFechaVencimientoLicencia() {
        return fechaVencimientoLicencia;
    }

    public void setFechaVencimientoLicencia(Date fechaVencimientoLicencia) {
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public List<Alquiler> getHistorialAlquileres() {
        return historialAlquileres;
    }

    public void setHistorialAlquileres(List<Alquiler> historialAlquileres) {
        this.historialAlquileres = historialAlquileres;
    }
}
