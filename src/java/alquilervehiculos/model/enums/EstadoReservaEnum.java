package alquilervehiculos.model.enums;

public enum EstadoReservaEnum {
    PENDIENTE(1),
    CONFIRMADA(2),
    CANCELADA(3),
    CONVERTIDA_ALQUILER(4);

    private final int id;

    private EstadoReservaEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de estado de reserva de la base de datos a EstadoReservaEnum
    public static EstadoReservaEnum fromId(int id) {
        for (EstadoReservaEnum estado : values()) {
            if (estado.getId() == id) {
                return estado;
            }
        }

        throw new IllegalArgumentException("ID de estado de reserva inválido: " + id);
    }
}
