package alquilervehiculos.util;

import java.util.Scanner;

public class InputManager {
    private static final Scanner scanner = new Scanner(System.in);

    private InputManager() {
        // Constructor privado para evitar instanciación (patrón Singleton)
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
