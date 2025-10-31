package alquilervehiculos.model.enums;

public enum MetodoPagoEnum {
    EFECTIVO(1),
    TARJETA_CREDITO(2),
    TARJETA_DEBITO(3),
    TRANSFERENCIA(4);

    private final int id;

    MetodoPagoEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de método de pago de la base de datos a MetodoPagoEnum
    public static MetodoPagoEnum fromId(int id) {
        for (MetodoPagoEnum estado : values()) {
            if (estado.getId() == id) {
                return estado;
            }
        }
        
        throw new IllegalArgumentException("Id de método de pago inválido: " + id);
    }
}
