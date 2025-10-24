package alquilervehiculos.model.entities;

public class Empresa {
    private int idReporte;
    private String nombreEmpresa;
    private String cuit;
    private String sitioWeb;
    private String direccion;
    private String ciudad;
    private String pais;

    public Empresa(int idReporte, String nombreEmpresa, String cuit, String sitioWeb, String direccion, String ciudad,
            String pais) {
        this.idReporte = idReporte;
        this.nombreEmpresa = nombreEmpresa;
        this.cuit = cuit;
        this.sitioWeb = sitioWeb;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    // Getters y Setters
    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
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
}
