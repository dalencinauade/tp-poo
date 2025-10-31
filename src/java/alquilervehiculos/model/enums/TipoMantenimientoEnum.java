package alquilervehiculos.model.enums;

public enum TipoMantenimientoEnum {
    PREVENTIVO(1),
    REVISION(2),
    REPARACION(3);

    private final int id;

    TipoMantenimientoEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de tipo de mantenimiento de la base de datos a TipoMantenimientoEnum
    public static TipoMantenimientoEnum fromId(int id) {
        for (TipoMantenimientoEnum estado : values()) {
            if (estado.getId() == id) {
                return estado;
            }
        }
        
        throw new IllegalArgumentException("Id de tipo de mantenimiento inválido: " + id);
    }
}
