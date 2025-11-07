package alquilervehiculos.controller;

import java.util.Date;
import java.util.List;

import alquilervehiculos.model.dto.ListarVehiculosDTO;
import alquilervehiculos.model.dto.ListarVehiculosDisponiblesDTO;
import alquilervehiculos.model.dto.ObtenerVehiculoParaEdicionDTO;
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
    
    public Respuesta crear(String categoria, String patente, String marca, String modelo, int anio, double precioDiario,
    double capacidadTanque, double capacidadTanqueMaxima, int kilometraje, String estado) {
        boolean exito = false;
        String mensaje = "";

        try {
            Vehiculo vehiculo = new Vehiculo(patente, marca, modelo, anio, precioDiario, capacidadTanque, capacidadTanqueMaxima, kilometraje, CategoriaVehiculoEnum.toEnum(categoria), EstadoVehiculoEnum.toEnum(estado));
            
            exito = vehiculoService.crear(vehiculo);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return new Respuesta(exito, mensaje);
    }

    public List<ListarVehiculosDTO> listarVehiculos() {
        try {
            return vehiculoService.listarVehiculos();
        } catch (Exception e) {
            return null;
        }
    }

    public ObtenerVehiculoParaEdicionDTO obtenerParaEdicion(int idVehiculo) {
        try {
            return vehiculoService.obtenerParaEdicion(idVehiculo);
        } catch (Exception e) {
            return null;
        }
    }

    public Respuesta editar(int idVehiculo, String categoria, String patente, String marca, String modelo, int anio, double precioDiario,
    double capacidadTanque, double capacidadTanqueMaxima, int kilometraje, String estado) {
        boolean exito = false;
        String mensaje = "";

        try {
            Vehiculo vehiculo = new Vehiculo(patente, marca, modelo, anio, precioDiario, capacidadTanque, capacidadTanqueMaxima, kilometraje, CategoriaVehiculoEnum.toEnum(categoria), EstadoVehiculoEnum.toEnum(estado));
            vehiculo.setIdVehiculo(idVehiculo);
            
            exito = vehiculoService.editar(vehiculo);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return new Respuesta(exito, mensaje);
    }

    public List<ListarVehiculosDisponiblesDTO> listarDisponibles(Date desde, Date hasta) {
        try {
            return vehiculoService.listarDisponibles(desde, hasta);
        } catch (Exception e) {
            return null;
        }
    }
}
