package alquilervehiculos.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.UsuarioController;

public class AdministrativoPrincipal extends JFrame {
    private final UsuarioController usuarioController;

    public AdministrativoPrincipal() {
        super("Panel principal");
        this.usuarioController = AppContext.getUsuarioController();
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        JLabel labelBienvenida = new JLabel("Bienvenido " + usuarioController.getSesionActual().getNombre());
        labelBienvenida.setBounds(30, 20, 300, 30);
        add(labelBienvenida);

        JButton btnLogout = new JButton("Cerrar sesión");
        btnLogout.setBounds(20, 80, 200, 25);
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
