package alquilervehiculos.util;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUtils {
    public static void clearScreen() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            // Para Windows
            if (os.contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para Linux o Mac
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("No se pudo limpiar la consola: " + e.getMessage());
        }
    }

    public static void pause(String message) {
        System.out.println(message);
        System.out.println("Presiona ENTER para continuar...");
        Scanner scanner = InputManager.getScanner();
        scanner.nextLine();
    }
}
