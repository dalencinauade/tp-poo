package alquilervehiculos.model.enums;

public enum TipoReporteEnum {
    DISPONIBILIDAD_VEHICULOS(1),
    CONTRATOS_ACTIVOS(2),
    INGRESOS_ALQUILER(3),
    MANTENIMIENTOS(4),
    CLIENTES_FRECUENTES(5);

    private final int id;

    TipoReporteEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de tipo de reporte de la base de datos a TipoReporteEnum
    public static TipoReporteEnum fromId(int id) {
        for (TipoReporteEnum estado : values()) {
            if (estado.getId() == id) {
                return estado;
            }
        }
        
        throw new IllegalArgumentException("Id de tipo de reporte inválido: " + id);
    }
}
