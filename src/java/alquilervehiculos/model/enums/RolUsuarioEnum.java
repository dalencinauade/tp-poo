package alquilervehiculos.model.enums;

public enum RolUsuarioEnum {
    ADMIN(1),
    CLIENTE(2),
    ADMINISTRATIVO(3),
    TECNICO(4),
    GERENTE(5);

    private final int id;

    RolUsuarioEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de rol de la base de datos a RolUsuarioEnum
    public static RolUsuarioEnum fromId(int id) {
        for (RolUsuarioEnum rol : values()) {
            if (rol.getId() == id) {
                return rol;
            }
        }
        
        throw new IllegalArgumentException("Id de rol no válido: " + id);
    }
}