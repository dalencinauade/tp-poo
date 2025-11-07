package alquilervehiculos.ui.utils;

import javax.swing.*;
import java.util.regex.Pattern;

public class Validacion {

    /**
     * Enum que define los tipos de validación disponibles
     */
    public enum TipoInput {
        TEXTO, // Texto genérico (solo verifica que no esté vacío)
        NUMERO_ENTERO, // Número entero
        NUMERO_ENTERO_POSITIVO, // Número entero positivo
        NUMERO_DECIMAL, // Número decimal
        NUMERO_DECIMAL_POSITIVO, // Número decimal positivo
        EMAIL // Email con formato válido
    }

    /**
     * Resultado de una validación
     */
    public static class ResultadoValidacion {
        public final boolean valido;
        public final String mensaje;

        private ResultadoValidacion(boolean valido, String mensaje) {
            this.valido = valido;
            this.mensaje = mensaje;
        }

        public static ResultadoValidacion exitoso() {
            return new ResultadoValidacion(true, "");
        }

        public static ResultadoValidacion error(String mensaje) {
            return new ResultadoValidacion(false, mensaje);
        }
    }

    // Patrones de validación
    private static final Pattern PATRON_EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    /**
     * Valida un JTextField según el tipo especificado
     * 
     * @param campo       El campo de texto a validar
     * @param tipo        El tipo de validación a aplicar
     * @param nombreCampo Nombre del campo para mensajes de error (opcional)
     * @return ResultadoValidacion con el resultado de la validación
     */
    public static ResultadoValidacion validar(JTextField campo, TipoInput tipo, String nombreCampo) {
        String valor = campo.getText().trim();
        String nombre = nombreCampo != null ? nombreCampo : "Campo";

        // Validar campo vacío
        if (valor.isEmpty()) {
            return ResultadoValidacion.error(nombre + " no puede estar vacío");
        }

        // Validaciones específicas por tipo
        return switch (tipo) {
            case TEXTO -> validarTexto(valor, nombre);
            case NUMERO_ENTERO -> validarNumeroEntero(valor, nombre, false);
            case NUMERO_ENTERO_POSITIVO -> validarNumeroEntero(valor, nombre, true);
            case NUMERO_DECIMAL -> validarNumeroDecimal(valor, nombre, false);
            case NUMERO_DECIMAL_POSITIVO -> validarNumeroDecimal(valor, nombre, true);
            case EMAIL -> validarEmail(valor, nombre);
        };
    }

    /**
     * Valida un JPasswordField
     * 
     * @param campo       El campo de contraseña a validar
     * @param nombreCampo Nombre del campo para mensajes de error (opcional)
     * @return ResultadoValidacion con el resultado de la validación
     */
    public static ResultadoValidacion validar(JPasswordField campo, String nombreCampo) {
        String valor = new String(campo.getPassword()).trim();
        String nombre = nombreCampo != null ? nombreCampo : "Contraseña";

        if (valor.isEmpty()) {
            return ResultadoValidacion.error(nombre + " no puede estar vacía");
        }

        if (valor.length() < 6) {
            return ResultadoValidacion.error(nombre + " debe tener al menos 6 caracteres");
        }

        return ResultadoValidacion.exitoso();
    }

    /**
     * Valida un JSpinner (fecha)
     * 
     * @param spinner     El spinner a validar
     * @param nombreCampo Nombre del campo para mensajes de error (opcional)
     * @return ResultadoValidacion con el resultado de la validación
     */
    public static ResultadoValidacion validar(JSpinner spinner, String nombreCampo) {
        String nombre = nombreCampo != null ? nombreCampo : "Campo";

        if (spinner.getValue() == null) {
            return ResultadoValidacion.error(nombre + " no puede estar vacío");
        }

        return ResultadoValidacion.exitoso();
    }

    /**
     * Valida múltiples campos y retorna el primer error encontrado
     * 
     * @param validaciones Array de resultados de validación
     * @return ResultadoValidacion con el primer error encontrado, o exitoso si
     *         todos son válidos
     */
    public static ResultadoValidacion validarTodos(ResultadoValidacion... validaciones) {
        for (ResultadoValidacion validacion : validaciones) {
            if (!validacion.valido) {
                return validacion;
            }
        }
        return ResultadoValidacion.exitoso();
    }

    // Métodos de validación privados

    private static ResultadoValidacion validarTexto(String valor, String nombre) {
        if (valor.length() < 2) {
            return ResultadoValidacion.error(nombre + " debe tener al menos 2 caracteres");
        }
        return ResultadoValidacion.exitoso();
    }

    private static ResultadoValidacion validarNumeroEntero(String valor, String nombre, boolean debeSerPositivo) {
        try {
            int num = Integer.parseInt(valor);
            if (debeSerPositivo && num <= 0) {
                return ResultadoValidacion.error(nombre + " debe ser positivo");
            }
            return ResultadoValidacion.exitoso();
        } catch (NumberFormatException e) {
            return ResultadoValidacion.error(nombre + " debe ser un número entero válido");
        }
    }

    private static ResultadoValidacion validarNumeroDecimal(String valor, String nombre, boolean debeSerPositivo) {
        try {
            double num = Double.parseDouble(valor);
            if (debeSerPositivo && num <= 0) {
                return ResultadoValidacion.error(nombre + " debe ser mayor a 0");
            }
            return ResultadoValidacion.exitoso();
        } catch (NumberFormatException e) {
            return ResultadoValidacion.error(nombre + " debe ser un número válido");
        }
    }

    private static ResultadoValidacion validarEmail(String valor, String nombre) {
        if (!PATRON_EMAIL.matcher(valor).matches()) {
            return ResultadoValidacion
                    .error(nombre + " debe tener un formato de email válido (ej: usuario@dominio.com)");
        }
        return ResultadoValidacion.exitoso();
    }
}
