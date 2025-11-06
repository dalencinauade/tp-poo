package alquilervehiculos.model.dto;

import alquilervehiculos.model.enums.EstadoAlquilerEnum;
import alquilervehiculos.model.enums.EstadoReservaEnum;

public class ClienteObtenerDatosInterfazDTO {
    private EstadoReservaEnum estadoReserva;
    private EstadoAlquilerEnum estadoAlquiler;

    public ClienteObtenerDatosInterfazDTO() {
        this.estadoReserva = null;
        this.estadoAlquiler = null;
    }

    public EstadoReservaEnum getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReservaEnum estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public EstadoAlquilerEnum getEstadoAlquiler() {
        return estadoAlquiler;
    }

    public void setEstadoAlquiler(EstadoAlquilerEnum estadoAlquiler) {
        this.estadoAlquiler = estadoAlquiler;
    }
}
