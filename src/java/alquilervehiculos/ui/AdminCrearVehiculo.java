package alquilervehiculos.ui;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.VehiculoController;
import alquilervehiculos.model.entities.Respuesta;
import alquilervehiculos.ui.utils.Validacion.ResultadoValidacion;
import alquilervehiculos.ui.utils.Validacion.TipoInput;

import javax.swing.*;

import static alquilervehiculos.ui.utils.Validacion.*;

import java.awt.*;

public class AdminCrearVehiculo extends JDialog {

    private final VehiculoController vehiculoController;

    private JComboBox<String> cmbCategoria, cmbEstado;
    private JTextField txtPatente, txtMarca, txtModelo, txtAnio;
    private JTextField txtPrecioDiario, txtCapacidadTanque, txtCapacidadTanqueMaxima, txtKilometraje;
    private JButton btnCrear, btnCancelar;

    public AdminCrearVehiculo(Dialog parent, boolean modal) {
        super(parent, modal);
        setTitle("Registrar Vehículo");
        vehiculoController = AppContext.getVehiculoController();
        init();
    }

    private void init() {
        setLayout(null);
        setSize(520, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        int labelX = 50;
        int fieldX = 250;
        int y = 30;
        int height = 25;
        int spacing = 35;

        // Categoría
        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(labelX, y, 150, height);
        cmbCategoria = new JComboBox<>(new String[] { "Compacto", "Sedán", "SUV", "Pickup", "Lujo", "Deportivo" });
        cmbCategoria.setBounds(fieldX, y, 200, height);
        add(lblCategoria);
        add(cmbCategoria);

        // Patente
        JLabel lblPatente = new JLabel("Patente:");
        lblPatente.setBounds(labelX, y += spacing, 150, height);
        txtPatente = new JTextField();
        txtPatente.setBounds(fieldX, y, 200, height);
        add(lblPatente);
        add(txtPatente);

        // Marca
        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(labelX, y += spacing, 150, height);
        txtMarca = new JTextField();
        txtMarca.setBounds(fieldX, y, 200, height);
        add(lblMarca);
        add(txtMarca);

        // Modelo
        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(labelX, y += spacing, 150, height);
        txtModelo = new JTextField();
        txtModelo.setBounds(fieldX, y, 200, height);
        add(lblModelo);
        add(txtModelo);

        // Año
        JLabel lblAnio = new JLabel("Año:");
        lblAnio.setBounds(labelX, y += spacing, 150, height);
        txtAnio = new JTextField();
        txtAnio.setBounds(fieldX, y, 200, height);
        add(lblAnio);
        add(txtAnio);

        // Precio Diario
        JLabel lblPrecio = new JLabel("Precio diario:");
        lblPrecio.setBounds(labelX, y += spacing, 150, height);
        txtPrecioDiario = new JTextField();
        txtPrecioDiario.setBounds(fieldX, y, 200, height);
        add(lblPrecio);
        add(txtPrecioDiario);

        // Capacidad Tanque
        JLabel lblCapacidad = new JLabel("Capacidad tanque (L):");
        lblCapacidad.setBounds(labelX, y += spacing, 200, height);
        txtCapacidadTanque = new JTextField();
        txtCapacidadTanque.setBounds(fieldX, y, 200, height);
        add(lblCapacidad);
        add(txtCapacidadTanque);

        // Capacidad Tanque Máxima
        JLabel lblCapacidadMax = new JLabel("Capacidad máxima (L):");
        lblCapacidadMax.setBounds(labelX, y += spacing, 200, height);
        txtCapacidadTanqueMaxima = new JTextField();
        txtCapacidadTanqueMaxima.setBounds(fieldX, y, 200, height);
        add(lblCapacidadMax);
        add(txtCapacidadTanqueMaxima);

        // Kilometraje
        JLabel lblKilometraje = new JLabel("Kilometraje:");
        lblKilometraje.setBounds(labelX, y += spacing, 150, height);
        txtKilometraje = new JTextField();
        txtKilometraje.setBounds(fieldX, y, 200, height);
        add(lblKilometraje);
        add(txtKilometraje);

        // Estado
        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(labelX, y += spacing, 150, height);
        cmbEstado = new JComboBox<>(new String[] { "Disponible", "En mantenimiento", "Fuera de servicio" });
        cmbEstado.setBounds(fieldX, y, 200, height);
        add(lblEstado);
        add(cmbEstado);

        // Botones
        btnCrear = new JButton("Crear");
        btnCrear.setBounds(110, y + 60, 120, 30);
        btnCrear.addActionListener(e -> crear());
        add(btnCrear);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(270, y + 60, 120, 30);
        btnCancelar.addActionListener(e -> cancelar());
        add(btnCancelar);

        setSize(520, y + 180);
    }

    private void cancelar() {
        this.dispose();
    }

    private void crear() {

        // Validación de inputs
        ResultadoValidacion resultado = validarTodos(
                validar(txtPatente, TipoInput.TEXTO, "Patente"),
                validar(txtMarca, TipoInput.TEXTO, "Marca"),
                validar(txtModelo, TipoInput.TEXTO, "Modelo"),
                validar(txtAnio, TipoInput.NUMERO_ENTERO_POSITIVO, "Año"),
                validar(txtPrecioDiario, TipoInput.NUMERO_DECIMAL_POSITIVO, "Precio diario"),
                validar(txtCapacidadTanque, TipoInput.NUMERO_DECIMAL_POSITIVO, "Capacidad tanque"),
                validar(txtCapacidadTanqueMaxima, TipoInput.NUMERO_DECIMAL_POSITIVO, "Capacidad tanque máxima"),
                validar(txtKilometraje, TipoInput.NUMERO_ENTERO_POSITIVO, "Kilometraje"));

        if (!resultado.valido) {
            JOptionPane.showMessageDialog(this, resultado.mensaje, "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que el año sea >= 1900 y <= el año actual + 1
        try {
            int anio = Integer.parseInt(txtAnio.getText().trim());
            int anioActual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
            if (anio < 1900 || anio > anioActual + 1) {
                JOptionPane.showMessageDialog(this,
                        "El año debe estar entre 1900 y " + (anioActual + 1),
                        "Error de validación",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al validar el año",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Si todas las validaciones pasan, continuar con la creación
        Respuesta respuesta = vehiculoController.crear((String) cmbCategoria.getSelectedItem(),
                txtPatente.getText().trim(),
                txtMarca.getText().trim(), txtModelo.getText().trim(),
                Integer.parseInt(txtAnio.getText().trim()),
                Double.parseDouble(txtPrecioDiario.getText().trim()),
                Double.parseDouble(txtCapacidadTanque.getText().trim()),
                Double.parseDouble(txtCapacidadTanqueMaxima.getText().trim()),
                Integer.parseInt(txtKilometraje.getText().trim()),
                (String) cmbEstado.getSelectedItem());

        if (respuesta.exito) {
            JOptionPane.showMessageDialog(this, "Vehículo guardado correctamente");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error: " + respuesta.mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
