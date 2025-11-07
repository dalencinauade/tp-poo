package alquilervehiculos.ui;

import javax.swing.*;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.UsuarioController;
import alquilervehiculos.model.entities.Respuesta;
import alquilervehiculos.model.entities.Sesion;
import alquilervehiculos.ui.utils.Validacion.ResultadoValidacion;
import alquilervehiculos.ui.utils.Validacion.TipoInput;

import static alquilervehiculos.ui.utils.Validacion.*;

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
        add(labelTitulo);

        JLabel labelUsername = new JLabel("Usuario:");
        labelUsername.setBounds(100, 60, 100, 25);
        add(labelUsername);
        JTextField txtUsername = new JTextField(20);
        txtUsername.setBounds(200, 60, 350, 25);
        txtUsername.setText("admin");
        add(txtUsername);

        JLabel labelPassword = new JLabel("Contraseña:");
        labelPassword.setBounds(100, 110, 100, 25);
        add(labelPassword);
        JPasswordField txtPassword = new JPasswordField(20);
        txtPassword.setBounds(200, 110, 350, 25);
        txtPassword.setText("admin");
        add(txtPassword);

        JButton btnLogin = new JButton("Iniciar sesión");
        btnLogin.setBounds(200, 160, 150, 25);
        btnLogin.addActionListener(e -> login(txtUsername, txtPassword));
        add(btnLogin);

        JButton btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds(400, 160, 150, 25);
        btnRegistro.addActionListener(e -> registrarse());
        add(btnRegistro);

        getRootPane().setDefaultButton(btnLogin);
    }

    private void login(JTextField txtUsername, JPasswordField txtPassword) {
        // Validar campos
        ResultadoValidacion resultado = validarTodos(
                validar(txtUsername, TipoInput.TEXTO, "Usuario"),
                validar(txtPassword, "Contraseña")
        );

        if (!resultado.valido) {
            JOptionPane.showMessageDialog(this, resultado.mensaje, "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Si todas las validaciones pasan, continuar con el login
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        
        Respuesta respuesta = usuarioController.login(username, password);

        if (respuesta.exito) {
            Sesion sesion = usuarioController.getSesionActual();
            JOptionPane.showMessageDialog(this, "Bienvenido " + sesion.getNombre() + "! (" + sesion.getRol() + ")");
            
            switch (sesion.getRol()) {
                case ADMIN -> new AdminPrincipal().setVisible(true);
                case CLIENTE -> new ClientePrincipal().setVisible(true);
                case ADMINISTRATIVO -> new AdministrativoPrincipal().setVisible(true);
                case TECNICO -> new TecnicoPrincipal().setVisible(true);
                case GERENTE -> new GerentePrincipal().setVisible(true);
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