package alquilervehiculos.ui;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.VehiculoController;
import alquilervehiculos.model.dto.ListarVehiculosDTO;
import alquilervehiculos.ui.components.ButtonEditor;
import alquilervehiculos.ui.components.ButtonRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdminVehiculos extends JDialog {

    private JTable tablaVehiculos;
    private DefaultTableModel modeloTabla;
    private VehiculoController vehiculoController = AppContext.getVehiculoController();

    public AdminVehiculos(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Administración de vehículos");
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);

        JButton btnCrearVehiculo = new JButton("Crear vehículo");
        btnCrearVehiculo.setBounds(30, 20, 150, 30);
        btnCrearVehiculo.addActionListener(e -> crearVehiculo());
        add(btnCrearVehiculo);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(200, 20, 150, 30);
        btnVolver.addActionListener(e -> volver());
        add(btnVolver);

        // Definir columnas
        String[] columnas = {"ID", "Patente", "Marca", "Modelo", "Año", "Kilometraje", "Categoría", "Estado", "Acción"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return col == 8; // Solo el botón es editable
            }
        };

        // Crear tabla
        tablaVehiculos = new JTable(modeloTabla);
        tablaVehiculos.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(tablaVehiculos);
        scroll.setBounds(30, 70, 730, 360);
        add(scroll);

        cargarVehiculos();
    }

    private void cargarVehiculos() {
        modeloTabla.setRowCount(0);
        List<ListarVehiculosDTO> lista = vehiculoController.listarVehiculos();

        for (ListarVehiculosDTO v : lista) {
            modeloTabla.addRow(new Object[]{
                v.getId(),
                v.getPatente(),
                v.getMarca(),
                v.getModelo(),
                v.getAnio(),
                v.getKilometraje(),
                v.getCategoria(),
                v.getEstado(),
                "Editar"
            });
        }

        tablaVehiculos.getColumn("Acción").setCellRenderer(new ButtonRenderer());
        tablaVehiculos.getColumn("Acción").setCellEditor(
            new ButtonEditor(new JCheckBox(), row -> editarVehiculo((int) tablaVehiculos.getValueAt(row, 0)))
        );
    }

    private void crearVehiculo() {
        new AdminCrearVehiculo(this, true).setVisible(true);
        cargarVehiculos();
    }

    private void editarVehiculo(int idVehiculo) {
        new AdminEditarVehiculo(this, true, idVehiculo).setVisible(true);
        cargarVehiculos();
    }

    private void volver() {
        this.dispose();
    }
}
