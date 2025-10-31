package alquilervehiculos.model.enums;

public enum EstadoVehiculoEnum {
    DISPONIBLE(1),
    ALQUILADO(2),
    MANTENIMIENTO(3),
    FUERA_DE_SERVICIO(4);

    private final int id;

    EstadoVehiculoEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de estado de vehículo de la base de datos a EstadoVehiculoEnum
    public static EstadoVehiculoEnum fromId(int id) {
        for (EstadoVehiculoEnum estado : values()) {
            if (estado.getId() == id) {
                return estado;
            }
        }
        
        throw new IllegalArgumentException("Id de estado de vehículo inválido: " + id);
    }
}
