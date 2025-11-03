package alquilervehiculos.model.enums;

public enum CategoriaVehiculoEnum {
    COMPACTO(1),
    SEDAN(2),
    SUV(3),
    PICKUP(4),
    LUJO(5),
    DEPORTIVO(6);

    private final int id;

    private CategoriaVehiculoEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para convertir el Id de categoría de vehículo de la base de datos a CategoriaVehiculoEnum
    public static CategoriaVehiculoEnum fromId(int id) {
        for (CategoriaVehiculoEnum categoria : values()) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Id de categoría de vehículo no válida: " + id);
    }

    public static String toString(CategoriaVehiculoEnum categoria) {
        switch (categoria) {
            case COMPACTO:
                return "Compacto";
            case SEDAN:
                return "Sedán";
            case SUV:
                return "SUV";
            case PICKUP:
                return "Pickup";
            case LUJO:
                return "Lujo";
            case DEPORTIVO:
                return "Deportivo";
            default:
                return "Desconocido";
        }
    }

    public static CategoriaVehiculoEnum toEnum(String categoria) {
        switch (categoria) {
            case "Compacto":
                return COMPACTO;
            case "Sedán":
                return SEDAN;
            case "SUV":
                return SUV;
            case "Pickup":
                return PICKUP;
            case "Lujo":
                return LUJO;
            case "Deportivo":
                return DEPORTIVO;
            default:
                return null;
        }
    }
}
