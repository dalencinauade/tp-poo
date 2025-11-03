package alquilervehiculos.ui;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.model.dto.ListarUsuariosDTO;
import alquilervehiculos.ui.components.ButtonEditor;
import alquilervehiculos.ui.components.ButtonRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdminVehiculos  extends JDialog {

    public AdminVehiculos(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Administración de vehículos");
        init();
    }

        private void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(700, 500);
        setResizable(false);
        setLocationRelativeTo(null);

        JButton btnCrearVehiculo = new JButton("Crear vehículo");
        btnCrearVehiculo.setBounds(30, 20, 150, 30);
        btnCrearVehiculo.addActionListener(e -> crearVehiculo());
        add(btnCrearVehiculo);

        // Tabla
        // String[] columnas = {"ID", "Usuario", "Nombre", "Apellido", "Rol", "Acción"};
        // modeloTabla = new DefaultTableModel(columnas, 0) {
        //     @Override public boolean isCellEditable(int row, int col) {
        //         return col == 5;
        //     }
        // };

        // tablaUsuarios = new JTable(modeloTabla);
        // tablaUsuarios.setRowHeight(25);

        // JScrollPane scroll = new JScrollPane(tablaUsuarios);
        // scroll.setBounds(30, 70, 630, 360);
        // add(scroll);

        cargarVehiculos();
    }
    
    private void cargarVehiculos() {
        // modeloTabla.setRowCount(0);
        // List<ListarUsuariosDTO> lista = usuarioController.listarUsuarios();

        // for (ListarUsuariosDTO u : lista) {
        //     modeloTabla.addRow(new Object[]{
        //         u.getId(),
        //         u.getUsername(),
        //         u.getNombre(),
        //         u.getApellido(),
        //         u.getRol(),
        //         "Editar"
        //     });
        // }

        // tablaUsuarios.getColumn("Acción").setCellRenderer(new ButtonRenderer());
        
        // tablaUsuarios.getColumn("Acción").setCellEditor(
        //     new ButtonEditor(new JCheckBox(), row -> editarUsuario((int) tablaUsuarios.getValueAt(row, 0)))
        // );
    }

    private void crearVehiculo() {
        new AdminCrearVehiculo(this, true).setVisible(true);
        cargarVehiculos();
    }

    private void editarVehiculo(int idVehiculo) {
        //new AdminEditarVehiculo(this, true, idVehiculo).setVisible(true);
        cargarVehiculos();
    }
}
