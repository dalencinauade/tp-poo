package alquilervehiculos.config;

import alquilervehiculos.controller.AdministrativoController;
import alquilervehiculos.controller.ClienteController;
import alquilervehiculos.controller.GerenteController;
import alquilervehiculos.controller.ReservaController;
import alquilervehiculos.controller.TecnicoController;
import alquilervehiculos.controller.UsuarioController;
import alquilervehiculos.controller.VehiculoController;
import alquilervehiculos.dao.AdministrativoDAO;
import alquilervehiculos.dao.ClienteDAO;
import alquilervehiculos.dao.EmpleadoDAO;
import alquilervehiculos.dao.GerenteDAO;
import alquilervehiculos.dao.PersonaDAO;
import alquilervehiculos.dao.ReservaDAO;
import alquilervehiculos.dao.TecnicoDAO;
import alquilervehiculos.dao.UsuarioDAO;
import alquilervehiculos.dao.VehiculoDAO;
import alquilervehiculos.service.AdministrativoService;
import alquilervehiculos.service.ClienteService;
import alquilervehiculos.service.GerenteService;
import alquilervehiculos.service.ReservaService;
import alquilervehiculos.service.TecnicoService;
import alquilervehiculos.service.UsuarioService;
import alquilervehiculos.service.VehiculoService;

public class AppContext {
    private static UsuarioController usuarioController;
    private static ClienteController clienteController;
    private static AdministrativoController administrativoController;
    private static TecnicoController tecnicoController;
    private static GerenteController gerenteController;
    private static VehiculoController vehiculoController;
    private static ReservaController reservaController;

    private AppContext() {
        // Constructor privado para evitar instanciación (patrón Singleton)
    }

    public static void init() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PersonaDAO personaDAO = new PersonaDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        AdministrativoDAO administrativoDAO = new AdministrativoDAO();
        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        GerenteDAO gerenteDAO = new GerenteDAO();
        VehiculoDAO vehiculoDAO = new VehiculoDAO();
        ReservaDAO reservaDAO = new ReservaDAO();

        UsuarioService usuarioService = new UsuarioService(usuarioDAO);
        ClienteService clienteService = new ClienteService(usuarioDAO, personaDAO, clienteDAO);
        AdministrativoService administrativoService = new AdministrativoService(usuarioDAO, personaDAO, empleadoDAO, administrativoDAO);
        TecnicoService tecnicoService = new TecnicoService(usuarioDAO, personaDAO, empleadoDAO, tecnicoDAO);
        GerenteService gerenteService = new GerenteService(usuarioDAO, personaDAO, empleadoDAO, gerenteDAO);
        VehiculoService vehiculoService = new VehiculoService(vehiculoDAO);
        ReservaService reservaService = new ReservaService(reservaDAO);
        
        usuarioController = new UsuarioController(usuarioService);
        clienteController = new ClienteController(clienteService);
        administrativoController = new AdministrativoController(administrativoService);
        tecnicoController = new TecnicoController(tecnicoService);
        gerenteController = new GerenteController(gerenteService);
        vehiculoController = new VehiculoController(vehiculoService);
        reservaController = new ReservaController(reservaService);
    }

    public static UsuarioController getUsuarioController() {
        return usuarioController;
    }

    public static ClienteController getClienteController() {
        return clienteController;
    }

    public static AdministrativoController getAdministrativoController() {
        return administrativoController;
    }

    public static TecnicoController getTecnicoController() {
        return tecnicoController;
    }

    public static GerenteController getGerenteController() {
        return gerenteController;
    }

    public static VehiculoController getVehiculoController() {
        return vehiculoController;
    }

    public static ReservaController getReservaController() {
        return reservaController;
    }
}
