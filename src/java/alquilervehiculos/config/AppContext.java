package alquilervehiculos.config;

import alquilervehiculos.controller.AdministrativoController;
import alquilervehiculos.controller.ClienteController;
import alquilervehiculos.controller.GerenteController;
import alquilervehiculos.controller.TecnicoController;
import alquilervehiculos.controller.UsuarioController;
import alquilervehiculos.dao.AdministrativoDAO;
import alquilervehiculos.dao.ClienteDAO;
import alquilervehiculos.dao.EmpleadoDAO;
import alquilervehiculos.dao.GerenteDAO;
import alquilervehiculos.dao.PersonaDAO;
import alquilervehiculos.dao.TecnicoDAO;
import alquilervehiculos.dao.UsuarioDAO;
import alquilervehiculos.service.AdministrativoService;
import alquilervehiculos.service.ClienteService;
import alquilervehiculos.service.GerenteService;
import alquilervehiculos.service.TecnicoService;
import alquilervehiculos.service.UsuarioService;

public class AppContext {
    private static UsuarioController usuarioController;
    private static ClienteController clienteController;
    private static AdministrativoController administrativoController;
    private static TecnicoController tecnicoController;
    private static GerenteController gerenteController;

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

        UsuarioService usuarioService = new UsuarioService(usuarioDAO);
        ClienteService clienteService = new ClienteService(usuarioDAO, personaDAO, clienteDAO);
        AdministrativoService administrativoService = new AdministrativoService(usuarioDAO, personaDAO, empleadoDAO, administrativoDAO);
        TecnicoService tecnicoService = new TecnicoService(usuarioDAO, personaDAO, empleadoDAO, tecnicoDAO);
        GerenteService gerenteService = new GerenteService(usuarioDAO, personaDAO, empleadoDAO, gerenteDAO);
        
        usuarioController = new UsuarioController(usuarioService);
        clienteController = new ClienteController(clienteService);
        administrativoController = new AdministrativoController(administrativoService);
        tecnicoController = new TecnicoController(tecnicoService);
        gerenteController = new GerenteController(gerenteService);
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
}
