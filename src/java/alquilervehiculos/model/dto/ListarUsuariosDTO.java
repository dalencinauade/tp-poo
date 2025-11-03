package alquilervehiculos.model.dto;

public class ListarUsuariosDTO {
    private int id;
    private String username;
    private String nombre;
    private String apellido;
    private String rol;

    public ListarUsuariosDTO(int id, String username, String nombre, String apellido, String rol) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRol() {
        return rol;
    }
}
