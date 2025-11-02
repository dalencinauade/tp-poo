package alquilervehiculos.ui;

import javax.swing.*;
import java.awt.*;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.UsuarioController;

public class ClientePrincipal extends JFrame {
    private final UsuarioController usuarioController;

    public ClientePrincipal() {
        super("Panel principal");
        this.usuarioController = AppContext.getUsuarioController();
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);

        JLabel labelBienvenida = new JLabel("Bienvenido " + usuarioController.getSesionActual().getNombre());
        add(labelBienvenida);

        JButton btnLogout = new JButton("Cerrar sesión");
        btnLogout.addActionListener(e -> logout());
        add(btnLogout);
    }

    private void logout() {
        usuarioController.logout();
        JOptionPane.showMessageDialog(this, "Sesión cerrada!");
        new Login().setVisible(true);
        this.dispose();
    }
}