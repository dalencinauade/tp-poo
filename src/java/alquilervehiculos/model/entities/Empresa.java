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

    // TODO: getters, setters and methods needed.
}
