package alquilervehiculos.model.enums;

public enum CategoriaVehiculoEnum {
    MOTO(1),
    COMPACTO(2),
    SEDAN(3),
    SUV(4),
    PICKUP(5),
    LUJO(6),
    DEPORTIVO(7);

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
}
