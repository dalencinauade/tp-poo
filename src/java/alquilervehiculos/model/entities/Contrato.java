package alquilervehiculos.model.entities;

import java.util.Date;

public class Contrato {
    private int idContrato;
    private Date fechaInicio;
    private Date fechaDevolucionPrevista;
    private double costoEstipulado;
    private String terminosCondiciones;
    private String firmaCliente;

    public Contrato(Date fechaInicio, Date fechaDevolucionPrevista, double costoEstipulado, String terminosCondiciones, String firmaCliente) {
        this.fechaInicio = fechaInicio;
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
        this.costoEstipulado = costoEstipulado;
        this.terminosCondiciones = terminosCondiciones;
        this.firmaCliente = firmaCliente;
    }

    // Getters y Setters
    public int getIdContrato() {
        return idContrato;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaDevolucionPrevista() {
        return fechaDevolucionPrevista;
    }

    public void setFechaDevolucionPrevista(Date fechaDevolucionPrevista) {
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
    }

    public double getCostoEstipulado() {
        return costoEstipulado;
    }

    public void setCostoEstipulado(double costoEstipulado) {
        this.costoEstipulado = costoEstipulado;
    }

    public String getTerminosCondiciones() {
        return terminosCondiciones;
    }

    public void setTerminosCondiciones(String terminosCondiciones) {
        this.terminosCondiciones = terminosCondiciones;
    }

    public String getFirmaCliente() {
        return firmaCliente;
    }

    public void setFirmaCliente(String firmaCliente) {
        this.firmaCliente = firmaCliente;
    }

    // Métodos de negocio

    /**
     * Genera el texto completo del contrato para impresión
     */
    public String generarTextoContrato(int kilometrajeInicial, double nivelCombustibleInicial, double costoEstimado) {
        StringBuilder texto = new StringBuilder();
        texto.append("=== CONTRATO DE ALQUILER ===\n");
        texto.append("ID Contrato: ").append(idContrato).append("\n");
        texto.append("Fecha Inicio: ").append(fechaInicio).append("\n");
        texto.append("Fecha Devolución Prevista: ").append(fechaDevolucionPrevista).append("\n");
        texto.append("Kilometraje Inicial: ").append(kilometrajeInicial).append(" km\n");
        texto.append("Nivel Combustible Inicial: ").append(nivelCombustibleInicial * 100).append("%\n");
        texto.append("Costo Estimado: $").append(costoEstimado).append("\n");
        texto.append("\nTérminos y Condiciones:\n").append(terminosCondiciones).append("\n");
        texto.append("\nFirma Cliente: ").append(firmaCliente).append("\n");
        //texto.append("Estado: ").append(estado).append("\n");
        return texto.toString();
    }
}
