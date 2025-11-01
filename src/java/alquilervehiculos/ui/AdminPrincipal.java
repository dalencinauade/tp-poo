package alquilervehiculos.ui;

import javax.swing.*;
import java.awt.*;

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
        setLayout(new FlowLayout());
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);

        JLabel labelBienvenida = new JLabel("Bienvenido " + usuarioController.getSesionActual().getNombre());
        JButton btnLogout = new JButton("Cerrar sesión");

        btnLogout.addActionListener(e -> logout());

        add(labelBienvenida);
        add(btnLogout);
    }

    private void logout() {
        usuarioController.logout();
        JOptionPane.showMessageDialog(this, "Sesión cerrada!");
        new Login().setVisible(true);
        this.dispose();
    }
}