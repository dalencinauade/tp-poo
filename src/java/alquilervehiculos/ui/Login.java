package alquilervehiculos.ui;

import javax.swing.*;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.UsuarioController;
import alquilervehiculos.model.entities.Respuesta;
import alquilervehiculos.model.entities.Sesion;

public class Login extends JFrame {
    private final UsuarioController usuarioController;

    public Login() {
        super("Inicio de sesión");
        this.usuarioController = AppContext.getUsuarioController();
        init();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(700, 300);
        setResizable(false);
        setLocationRelativeTo(null);

        JLabel labelTitulo = new JLabel("Alquiler de vehículos");
        labelTitulo.setBounds(280, 20, 200, 25);

        JLabel labelUsername = new JLabel("Usuario:");
        labelUsername.setBounds(100, 60, 100, 25);
        JTextField textUsername = new JTextField(20);
        textUsername.setBounds(200, 60, 350, 25);
        textUsername.setText("admin");

        JLabel labelPassword = new JLabel("Contraseña:");
        labelPassword.setBounds(100, 110, 100, 25);
        JPasswordField textPassword = new JPasswordField(20);
        textPassword.setBounds(200, 110, 350, 25);
        textPassword.setText("admin");

        JButton btnLogin = new JButton("Iniciar sesión");
        btnLogin.setBounds(200, 160, 150, 25);

        JButton btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds(400, 160, 150, 25);

        getRootPane().setDefaultButton(btnLogin);

        btnLogin.addActionListener(e -> login(textUsername.getText(), new String(textPassword.getPassword())));

        btnRegistro.addActionListener(e -> registrarse());

        add(labelTitulo);
        add(labelUsername);
        add(textUsername);
        add(labelPassword);
        add(textPassword);
        add(btnLogin);
        add(btnRegistro);
    }

    private void login(String username, String password) {
        Respuesta respuesta = usuarioController.login(username, password);

        if (respuesta.exito) {
            Sesion sesion = usuarioController.getSesionActual();
            JOptionPane.showMessageDialog(this, "Bienvenido " + sesion.getNombre() + "! (" + sesion.getRol() + ")");
            
            switch (sesion.getRol()) {
                case ADMIN -> new AdminPrincipal().setVisible(true);
                case CLIENTE -> new ClientePrincipal().setVisible(true);
                //case ADMINISTRATIVO -> new AdministrativoPrincipal().setVisible(true);
                //case TECNICO -> new TecnicoPrincipal().setVisible(true);
                //case GERENTE -> new GerentePrincipal().setVisible(true);
            }

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error: " + respuesta.mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarse() {
        new RegistroUsuario().setVisible(true);
        this.dispose();
    }
}