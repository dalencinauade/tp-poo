package alquilervehiculos.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente extends Persona {
    private int idCliente;
    private String numeroLicencia;
    private Date fechaVencimientoLicencia;

    public Cliente(String numeroLicencia, Date fechaVencimientoLicencia, String nombre, String apellido, String email, String dni, String telefono, String direccion, Date fechaNacimiento) {
        super(nombre, apellido, email, dni, telefono, direccion, fechaNacimiento);
        
        this.numeroLicencia = numeroLicencia;
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
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

    public String getFechaVencimientoLicenciaString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fechaVencimientoLicencia);
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
}
