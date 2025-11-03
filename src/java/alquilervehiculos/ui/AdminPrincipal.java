package alquilervehiculos.ui;

import javax.swing.*;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.UsuarioController;

public class AdminPrincipal extends JFrame {
    private final UsuarioController usuarioController;

    public AdminPrincipal() {
        super("Panel principal");
        this.usuarioController = AppContext.getUsuarioController();;
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        JLabel labelBienvenida = new JLabel("Bienvenido " + usuarioController.getSesionActual().getNombre());
        labelBienvenida.setBounds(20, 20, 200, 25);
        add(labelBienvenida);

        JButton btnUsuarios = new JButton("Administración de usuarios");
        btnUsuarios.setBounds(20, 50, 200, 25);
        btnUsuarios.addActionListener(e -> adminUsuarios());
        add(btnUsuarios);

        JButton btnVehiculos = new JButton("Administración de vehículos");
        btnVehiculos.setBounds(20, 80, 200, 25);
        btnVehiculos.addActionListener(e -> adminVehiculos());
        add(btnVehiculos);

        JButton btnLogout = new JButton("Cerrar sesión");
        btnLogout.setBounds(20, 110, 200, 25);
        btnLogout.addActionListener(e -> logout());
        add(btnLogout);
    }

    private void adminUsuarios() {
        new AdminUsuarios(this, true).setVisible(true);
    }

    private void adminVehiculos() {
        new AdminVehiculos(this, true).setVisible(true);
    }

    private void logout() {
        usuarioController.logout();
        JOptionPane.showMessageDialog(this, "Sesión cerrada!");
        new Login().setVisible(true);
        this.dispose();
    }
}