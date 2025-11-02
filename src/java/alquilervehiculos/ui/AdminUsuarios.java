package alquilervehiculos.ui;

import java.awt.Frame;
import javax.swing.*;

public class AdminUsuarios extends JDialog {
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
        btnCrearUsuario.setBounds(130, 70, 200, 25);
        btnCrearUsuario.addActionListener(e -> crearUsuario());
        add(btnCrearUsuario);
    }

    private void crearUsuario() {
        new AdminCrearUsuario(this, true).setVisible(true);
    }
    
}
