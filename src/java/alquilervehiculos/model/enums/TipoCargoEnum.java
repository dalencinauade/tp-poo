package alquilervehiculos.model.enums;

public enum TipoCargoEnum {
    DEVOLUCION_TARDIA(1),
    KILOMETRAJE_EXTRA(2),
    DANIO_VEHICULO(3),
    FALTA_COMBUSTIBLE(4),
    LIMPIEZA(5);

    private final int id;

    TipoCargoEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de tipo de cargo de la base de datos a TipoCargoEnum
    public static TipoCargoEnum fromId(int id) {
        for (TipoCargoEnum estado : values()) {
            if (estado.getId() == id) {
                return estado;
            }
        }
        
        throw new IllegalArgumentException("Id de tipo de cargo inválido: " + id);
    }
}
