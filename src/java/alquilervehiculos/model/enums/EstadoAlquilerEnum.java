package alquilervehiculos.model.enums;

public enum EstadoAlquilerEnum {
    VIGENTE(1),
    FINALIZADO(2),
    CANCELADO(3);

    private final int id;

    EstadoAlquilerEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de estado de alquiler de la base de datos a EstadoAlquilerEnum
    public static EstadoAlquilerEnum fromId(int id) {
        for (EstadoAlquilerEnum estado : values()) {
            if (estado.getId() == id) {
                return estado;
            }
        }
        
        throw new IllegalArgumentException("Id de estado de alquiler inválido: " + id);
    }
}
