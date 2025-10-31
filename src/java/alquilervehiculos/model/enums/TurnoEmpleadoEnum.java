package alquilervehiculos.model.enums;

public enum TurnoEmpleadoEnum {
    MANIANA(1),
    TARDE(2),
    NOCHE(3);

    private final int id;

    TurnoEmpleadoEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de turno de la base de datos a TurnoEmpleadoEnum
    public static TurnoEmpleadoEnum fromId(int id) {
        for (TurnoEmpleadoEnum turno : values()) {
            if (turno.getId() == id) {
                return turno;
            }
        }
        
        throw new IllegalArgumentException("Id de turno no válido: " + id);
    }
}
