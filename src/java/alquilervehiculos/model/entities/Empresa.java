package alquilervehiculos.model.entities;

public class Empresa {
    private int idEmpresa;
    private String nombreEmpresa;
    private String cuit;
    private String sitioWeb;
    private String direccion;
    private String ciudad;
    private String pais;

    public Empresa(int idEmpresa, String nombreEmpresa, String cuit) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.cuit = cuit;
    }

    // Getters y Setters
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    // Métodos de negocio

    /**
     * Obtiene la información completa de la empresa
     */
    public String obtenerInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("=== INFORMACIÓN DE LA EMPRESA ===\n");
        info.append("Nombre: ").append(nombreEmpresa).append("\n");
        info.append("CUIT: ").append(cuit).append("\n");
        info.append("Sitio Web: ").append(sitioWeb).append("\n");
        info.append("Dirección: ").append(direccion).append("\n");
        info.append("Ciudad: ").append(ciudad).append("\n");
        info.append("País: ").append(pais).append("\n");
        return info.toString();
    }

    /**
     * Valida si la empresa tiene todos los datos básicos completos
     */
    public boolean tieneInformacionCompleta() {
        return nombreEmpresa != null && !nombreEmpresa.isEmpty() &&
                cuit != null && !cuit.isEmpty() &&
                direccion != null && !direccion.isEmpty();
    }
}
