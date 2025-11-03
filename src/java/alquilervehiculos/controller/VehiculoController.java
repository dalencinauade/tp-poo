package alquilervehiculos.controller;

import alquilervehiculos.model.entities.Respuesta;
import alquilervehiculos.model.entities.Vehiculo;
import alquilervehiculos.model.enums.CategoriaVehiculoEnum;
import alquilervehiculos.model.enums.EstadoVehiculoEnum;
import alquilervehiculos.service.VehiculoService;

public class VehiculoController {
    private VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }
    
    public Respuesta guardar(String categoria, String patente, String marca, String modelo, int anio, double precioDiario,
    double capacidadTanque, double capacidadTanqueMaxima, int kilometraje, String estado) {
        boolean exito = false;
        String mensaje = "";

        try {
            Vehiculo vehiculo = new Vehiculo(patente, marca, modelo, anio, precioDiario, capacidadTanque, capacidadTanqueMaxima, kilometraje, CategoriaVehiculoEnum.toEnum(categoria), EstadoVehiculoEnum.toEnum(estado));
            
            exito = vehiculoService.guardar(vehiculo);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return new Respuesta(exito, mensaje);
    }
}
