package alquilervehiculos.model.entities;

import java.util.Date;

public class Contrato {
    private int idContrato;
    private Date fechaInicio;
    private Date fechaDevolucionPrevista;
    private Date fechaDevolucionReal;
    private int kilometrajeInicial;
    private double nivelCombustibleInicial;
    private double costoEstimado;
    private double costoTotal;
    private String terminosCondiciones;
    private String firmaCliente;
    private String estado; // VIGENTE, FINALIZADO, CANCELADO
    private Alquiler alquiler; // Relación 1:1 con Alquiler

    public Contrato(int idContrato, Date fechaInicio, Date fechaDevolucionPrevista,
            Date fechaDevolucionReal, int kilometrajeInicial, double nivelCombustibleInicial,
            double costoEstimado, double costoTotal, String terminosCondiciones,
            String firmaCliente, String estado, Alquiler alquiler) {
        this.idContrato = idContrato;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.kilometrajeInicial = kilometrajeInicial;
        this.nivelCombustibleInicial = nivelCombustibleInicial;
        this.costoEstimado = costoEstimado;
        this.costoTotal = costoTotal;
        this.terminosCondiciones = terminosCondiciones;
        this.firmaCliente = firmaCliente;
        this.estado = estado;
        this.alquiler = alquiler;
    }

    // Getters y Setters
    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
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

    public Date getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(Date fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public double getCostoEstimado() {
        return costoEstimado;
    }

    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
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

    public int getKilometrajeInicial() {
        return kilometrajeInicial;
    }

    public void setKilometrajeInicial(int kilometrajeInicial) {
        this.kilometrajeInicial = kilometrajeInicial;
    }

    public double getNivelCombustibleInicial() {
        return nivelCombustibleInicial;
    }

    public void setNivelCombustibleInicial(double nivelCombustibleInicial) {
        this.nivelCombustibleInicial = nivelCombustibleInicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    // Métodos de negocio
    
    /**
     * Finaliza el contrato
     */
    public void finalizar() {
        this.estado = "FINALIZADO";
    }

    /**
     * Cancela el contrato
     */
    public void cancelar() {
        this.estado = "CANCELADO";
    }

    /**
     * Verifica si el contrato está vigente
     */
    public boolean estaVigente() {
        return "VIGENTE".equals(this.estado);
    }

    /**
     * Genera el texto completo del contrato para impresión
     */
    public String generarTextoContrato() {
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
        texto.append("Estado: ").append(estado).append("\n");
        return texto.toString();
    }
}
