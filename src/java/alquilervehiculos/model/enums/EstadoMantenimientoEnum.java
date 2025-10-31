package alquilervehiculos.model.enums;

public enum EstadoMantenimientoEnum {
    EN_PROCESO(1),
    COMPLETADO(2);

    private final int id;

    private EstadoMantenimientoEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de estado de mantenimiento de la base de datos a EstadoMantenimientoEnum
    public static EstadoMantenimientoEnum fromId(int id) {
        for (EstadoMantenimientoEnum estado : EstadoMantenimientoEnum.values()) {
            if (estado.getId() == id) {
                return estado;
            }
        }

        throw new IllegalArgumentException("Id de estado de mantenimiento inválido: " + id);
    }
}
