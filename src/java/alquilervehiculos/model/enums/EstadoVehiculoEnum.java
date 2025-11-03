package alquilervehiculos.model.enums;

public enum EstadoVehiculoEnum {
    DISPONIBLE(1),
    ALQUILADO(2),
    EN_MANTENIMIENTO(3),
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

    public static String toString(EstadoVehiculoEnum categoria) {
        switch (categoria) {
            case DISPONIBLE:
                return "Disponible";
            case ALQUILADO:
                return "Alquilado";
            case EN_MANTENIMIENTO:
                return "En mantenimiento";
            case FUERA_DE_SERVICIO:
                return "Fuera de servicio";
            default:
                return "Desconocido";
        }
    }

    public static EstadoVehiculoEnum toEnum(String estado) {
        switch (estado) {
            case "Disponible":
                return DISPONIBLE;
            case "Alquilado":
                return ALQUILADO;
            case "En mantenimiento":
                return EN_MANTENIMIENTO;
            case "Fuera de servicio":
                return FUERA_DE_SERVICIO;
            default:
                return null;
        }
    }
}
