package alquilervehiculos.ui;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.VehiculoController;
import alquilervehiculos.model.dto.ObtenerVehiculoParaEdicionDTO;
import alquilervehiculos.model.entities.Respuesta;
import alquilervehiculos.model.enums.CategoriaVehiculoEnum;
import alquilervehiculos.model.enums.EstadoVehiculoEnum;

import javax.swing.*;
import java.awt.*;

public class AdminEditarVehiculo extends JDialog {

    private final VehiculoController vehiculoController;

    private JComboBox<String> cmbCategoria, cmbEstado;
    private JTextField txtPatente, txtMarca, txtModelo, txtAnio, txtPrecioDiario,
            txtCapacidadTanque, txtCapacidadTanqueMaxima, txtKilometraje;

    private JButton btnEditar, btnCancelar;

    private int idVehiculo;

    public AdminEditarVehiculo(Dialog parent, boolean modal, int idVehiculo) {
        super(parent, modal);
        setTitle("Editar Vehículo");

        this.vehiculoController = AppContext.getVehiculoController();
        this.idVehiculo = idVehiculo;

        init();
        cargarDatosVehiculo(idVehiculo);
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
        cmbCategoria = new JComboBox<>(new String[]{"Compacto", "Sedán", "SUV", "Pickup", "Lujo", "Deportivo"});
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
        JLabel lblPrecioDiario = new JLabel("Precio diario:");
        lblPrecioDiario.setBounds(labelX, y += spacing, 150, height);
        txtPrecioDiario = new JTextField();
        txtPrecioDiario.setBounds(fieldX, y, 200, height);
        add(lblPrecioDiario);
        add(txtPrecioDiario);

        // Capacidad del tanque
        JLabel lblCapacidadTanque = new JLabel("Capacidad tanque:");
        lblCapacidadTanque.setBounds(labelX, y += spacing, 150, height);
        txtCapacidadTanque = new JTextField();
        txtCapacidadTanque.setBounds(fieldX, y, 200, height);
        add(lblCapacidadTanque);
        add(txtCapacidadTanque);

        // Capacidad máxima del tanque
        JLabel lblCapacidadTanqueMax = new JLabel("Capacidad tanque máx:");
        lblCapacidadTanqueMax.setBounds(labelX, y += spacing, 200, height);
        txtCapacidadTanqueMaxima = new JTextField();
        txtCapacidadTanqueMaxima.setBounds(fieldX, y, 200, height);
        add(lblCapacidadTanqueMax);
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
        cmbEstado = new JComboBox<>(new String[]{"Disponible", "En mantenimiento", "Fuera de servicio"});
        cmbEstado.setBounds(fieldX, y, 200, height);
        add(lblEstado);
        add(cmbEstado);

        // Botones
        btnEditar = new JButton("Editar");
        btnEditar.setBounds(110, y + 50, 120, 30);
        btnEditar.addActionListener(e -> editar());
        add(btnEditar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(270, y + 50, 120, 30);
        btnCancelar.addActionListener(e -> cancelar());
        add(btnCancelar);

        setSize(520, y + 150);
    }

    private void cargarDatosVehiculo(int idVehiculo) {
        ObtenerVehiculoParaEdicionDTO vehiculo = vehiculoController.obtenerParaEdicion(idVehiculo);

        if (vehiculo != null) {
            cmbCategoria.setSelectedItem(vehiculo.getCategoria());
            txtPatente.setText(vehiculo.getPatente());
            txtMarca.setText(vehiculo.getMarca());
            txtModelo.setText(vehiculo.getModelo());
            txtAnio.setText(String.valueOf(vehiculo.getAnio()));
            txtPrecioDiario.setText(String.valueOf(vehiculo.getPrecioDiario()));
            txtCapacidadTanque.setText(String.valueOf(vehiculo.getCapacidadTanque()));
            txtCapacidadTanqueMaxima.setText(String.valueOf(vehiculo.getCapacidadTanqueMaxima()));
            txtKilometraje.setText(String.valueOf(vehiculo.getKilometraje()));
            cmbEstado.setSelectedItem(vehiculo.getEstado());
        } else {
            JOptionPane.showMessageDialog(this, "Error al obtener el vehículo", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }

    private void editar() {
        Respuesta respuesta = vehiculoController.editar(this.idVehiculo, (String) cmbCategoria.getSelectedItem(), txtPatente.getText(), txtMarca.getText(),
        txtModelo.getText(), Integer.parseInt(txtAnio.getText()), Double.parseDouble(txtPrecioDiario.getText()),
        Double.parseDouble(txtCapacidadTanque.getText()), Double.parseDouble(txtCapacidadTanqueMaxima.getText()),
        Integer.parseInt(txtKilometraje.getText()), (String) cmbEstado.getSelectedItem());

        if (respuesta.exito) {
            JOptionPane.showMessageDialog(this, "Vehículo editado correctamente");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error: " + respuesta.mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelar() {
        this.dispose();
    }
}
