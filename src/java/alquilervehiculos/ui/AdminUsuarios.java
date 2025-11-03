package alquilervehiculos.ui;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.UsuarioController;
import alquilervehiculos.model.dto.ListarUsuariosDTO;
import alquilervehiculos.ui.components.ButtonEditor;
import alquilervehiculos.ui.components.ButtonRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdminUsuarios extends JDialog {

    private JTable tablaUsuarios;
    private DefaultTableModel modeloTabla;
    private UsuarioController usuarioController = AppContext.getUsuarioController();

    public AdminUsuarios(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Administración de usuarios");
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(700, 500);
        setResizable(false);
        setLocationRelativeTo(null);

        JButton btnCrearUsuario = new JButton("Crear usuario");
        btnCrearUsuario.setBounds(30, 20, 150, 30);
        btnCrearUsuario.addActionListener(e -> crearUsuario());
        add(btnCrearUsuario);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(200, 20, 150, 30);
        btnVolver.addActionListener(e -> volver());
        add(btnVolver);

        // Tabla
        String[] columnas = {"ID", "Usuario", "Nombre", "Apellido", "Rol", "Acción"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override public boolean isCellEditable(int row, int col) {
                return col == 5;
            }
        };

        tablaUsuarios = new JTable(modeloTabla);
        tablaUsuarios.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(tablaUsuarios);
        scroll.setBounds(30, 70, 630, 360);
        add(scroll);

        cargarUsuarios();
    }

    private void cargarUsuarios() {
        modeloTabla.setRowCount(0);
        List<ListarUsuariosDTO> lista = usuarioController.listarUsuarios();

        for (ListarUsuariosDTO u : lista) {
            modeloTabla.addRow(new Object[]{
                u.getId(),
                u.getUsername(),
                u.getNombre(),
                u.getApellido(),
                u.getRol(),
                "Editar"
            });
        }

        tablaUsuarios.getColumn("Acción").setCellRenderer(new ButtonRenderer());
        
        tablaUsuarios.getColumn("Acción").setCellEditor(
            new ButtonEditor(new JCheckBox(), row -> editarUsuario((int) tablaUsuarios.getValueAt(row, 0)))
        );
    }

    private void crearUsuario() {
        new AdminCrearUsuario(this, true).setVisible(true);
        cargarUsuarios();
    }

    private void editarUsuario(int idUsuario) {
        new AdminEditarUsuario(this, true, idUsuario).setVisible(true);
        cargarUsuarios();
    }

    private void volver() {
        this.dispose();
    }
}