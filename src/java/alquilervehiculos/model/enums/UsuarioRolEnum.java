package alquilervehiculos.model.enums;

public enum UsuarioRolEnum {
    ADMIN(1),
    CLIENTE(2),
    ADMINISTRATIVO(3),
    TECNICO(4),
    GERENTE(5);

    private final int id;

    UsuarioRolEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de rol de la base de datos a USUARIOROLENUM
    public static UsuarioRolEnum fromId(int id) {
        for (UsuarioRolEnum rol : values()) {
            if (rol.getId() == id) {
                return rol;
            }
        }
        
        throw new IllegalArgumentException("Id de rol no válido: " + id);
    }
}