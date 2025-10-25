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
    private int limiteClienteFrecuente = 5;

    public Cliente(int dni, int idCliente, String numeroLicencia, Date fechaVencimientoLicencia, String tipoLicencia) {
        super(dni);
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

    // Métodos de negocio

    /**
     * Verifica si la licencia está vigente
     */
    public boolean tieneLicenciaVigente() {
        if (this.fechaVencimientoLicencia == null) {
            return false;
        }
        return this.fechaVencimientoLicencia.after(new Date());
    }

    /**
     * Agrega un alquiler al historial del cliente
     */
    public void agregarAlquiler(Alquiler alquiler) {
        this.historialAlquileres.add(alquiler);
    }

    /**
     * Obtiene la cantidad de alquileres realizados
     */
    public int getCantidadAlquileres() {
        return this.historialAlquileres.size();
    }

    /**
     * Verifica si es un cliente frecuente (más de 5 alquileres)
     */
    public boolean esClienteFrecuente() {
        return this.historialAlquileres.size() >= this.limiteClienteFrecuente;
    }
}
