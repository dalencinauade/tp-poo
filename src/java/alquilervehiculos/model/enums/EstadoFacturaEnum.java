package alquilervehiculos.model.enums;

public enum EstadoFacturaEnum {
    EMITIDA(1),
    PAGADA(2),
    ANULADA(3),
    VENCIDA(4);

    private final int id;

    EstadoFacturaEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de estado de factura de la base de datos a EstadoFacturaEnum
    public static EstadoFacturaEnum fromId(int id) {
        for (EstadoFacturaEnum estado : values()) {
            if (estado.getId() == id) {
                return estado;
            }
        }
        
        throw new IllegalArgumentException("Id de estado de factura inválido: " + id);
    }
}
