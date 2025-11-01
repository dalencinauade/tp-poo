package alquilervehiculos.model.entities;

public class Respuesta {
    public boolean exito;
    public String mensaje;

    public Respuesta(boolean exito, String mensaje) {
        this.exito = exito;
        this.mensaje = mensaje;
    }
}
