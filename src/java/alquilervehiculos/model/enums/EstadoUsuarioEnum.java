package alquilervehiculos.model.enums;

public enum EstadoUsuarioEnum {
    ACTIVO(1),
    INACTIVO(2),
    BLOQUEADO(3),
    SUSPENDIDO(4);

    private final int id;

    EstadoUsuarioEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de estado de la base de datos a EstadoUsuarioEnum
    public static EstadoUsuarioEnum fromId(int id) {
        for (EstadoUsuarioEnum estado : values()) {
            if (estado.getId() == id) {
                return estado;
            }
        }
        
        throw new IllegalArgumentException("Id de estado no válido: " + id);
    }
}
