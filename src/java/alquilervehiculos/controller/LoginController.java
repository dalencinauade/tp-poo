package alquilervehiculos.controller;

import alquilervehiculos.service.LoginService;
import alquilervehiculos.util.ConsoleUtils;
import alquilervehiculos.util.InputManager;
import alquilervehiculos.model.entities.Sesion;
import java.util.Scanner;

public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public void iniciarSesion() {
        boolean salir = false;

        // Bucle principal de la aplicación. Se mantiene hasta que el usuario decide salir.
        while (!salir) {
            if (!loginService.existeSesionActiva()) {
                mostrarLogin();
            } else {
                salir = mostrarMenuRol();
            }
        }
    }

    private void mostrarLogin() {
        ConsoleUtils.clearScreen();
        Scanner scanner = InputManager.getScanner();
        System.out.println("--- Iniciar Sesión ---");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        try {
            // Acá intentamos loguearnos. Si el login falla, mostramos el mensaje de error.
            // Si el login es exitoso, el menú del rol se mostrará en la siguiente iteración del while de iniciarSesion().
            if (!loginService.login(email, password)) {
                ConsoleUtils.pause("Datos inválidos. Intente nuevamente.");
            }
        } catch (Exception e) {
            ConsoleUtils.pause("Error al intentar iniciar sesión: " + e.getMessage());
        }
    }

    private boolean mostrarMenuRol() {
        Sesion sesion = loginService.getSesionActual();
        boolean salir = false;

        switch (sesion.getRol()) {
            case ADMIN:
                salir = mostrarMenuAdmin(); // TODO: esto hay que mudarlo a un AdminController con sus propios menues
                break;

            // Repetir por cada rol.
            case CLIENTE:
            case ADMINISTRATIVO:
            case TECNICO:
            case GERENTE:
                break;
        }

        return salir;
    }

    // Temporal. Tiene que mudarse a su propio controller
    private boolean mostrarMenuAdmin() {
        ConsoleUtils.clearScreen();
        Scanner scanner = InputManager.getScanner();
        System.out.println("--- Menú ADMIN ---");
        System.out.println("1) Gestionar usuarios");
        System.out.println("2) Gestionar vehículos");
        System.out.println("9) Cerrar sesión");
        System.out.println("0) Salir del sistema");
        System.out.print("\nOpción: ");
        String opcion = scanner.nextLine();
        boolean result = false;

        switch (opcion) {
            case "9":
                loginService.logout();
                break;
            case "0":
                result = true;
                break;
        }

        return result;
    }
}
