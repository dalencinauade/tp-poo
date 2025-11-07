package alquilervehiculos.ui;

import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.ClienteController;
import alquilervehiculos.model.entities.Respuesta;
import alquilervehiculos.ui.utils.Validacion.ResultadoValidacion;
import alquilervehiculos.ui.utils.Validacion.TipoInput;

import static alquilervehiculos.ui.utils.Validacion.*;

public class RegistroUsuario extends JFrame {
    private final ClienteController clienteController;

    public RegistroUsuario() {
        super("Registro de usuario");
        this.clienteController = AppContext.getClienteController();
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setSize(500, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        int labelX = 50;
        int fieldX = 200;
        int y = 70;
        int height = 25;
        int spacing = 35;
        Calendar cal = Calendar.getInstance();

        JLabel lblTitulo = new JLabel("Registro de Usuario");
        lblTitulo.setBounds(160, 15, 250, 30);
        add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(labelX, y, 150, height);
        add(lblNombre);
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(fieldX, y, 200, height);
        add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(labelX, y += spacing, 150, height);
        add(lblApellido);
        JTextField txtApellido = new JTextField();
        txtApellido.setBounds(fieldX, y, 200, height);
        add(txtApellido);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(labelX, y += spacing, 150, height);
        add(lblEmail);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(fieldX, y, 200, height);
        add(txtEmail);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(labelX, y += spacing, 150, height);
        add(lblDni);
        JTextField txtDni = new JTextField();
        txtDni.setBounds(fieldX, y, 200, height);
        add(txtDni);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(labelX, y += spacing, 150, height);
        add(lblTelefono);
        JTextField txtTelefono = new JTextField();
        txtTelefono.setBounds(fieldX, y, 200, height);
        add(txtTelefono);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(labelX, y += spacing, 150, height);
        add(lblDireccion);
        JTextField txtDireccion = new JTextField();
        txtDireccion.setBounds(fieldX, y, 200, height);
        add(txtDireccion);

        JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
        lblFechaNacimiento.setBounds(labelX, y += spacing, 150, height);
        add(lblFechaNacimiento);

        cal.set(2000, Calendar.JANUARY, 1);
        SpinnerDateModel modelNacimiento = new SpinnerDateModel(cal.getTime(), null, null, Calendar.DAY_OF_MONTH);
        JSpinner spinnerNacimiento = new JSpinner(modelNacimiento);
        spinnerNacimiento.setBounds(fieldX, y, 200, height);
        spinnerNacimiento.setEditor(new JSpinner.DateEditor(spinnerNacimiento, "yyyy-MM-dd"));
        add(spinnerNacimiento);

        JLabel lblNumeroLicencia = new JLabel("Número de licencia:");
        lblNumeroLicencia.setBounds(labelX, y += spacing, 150, height);
        add(lblNumeroLicencia);
        JTextField txtNumeroLicencia = new JTextField();
        txtNumeroLicencia.setBounds(fieldX, y, 200, height);
        add(txtNumeroLicencia);

        JLabel lblVencimiento = new JLabel("Vencimiento de licencia:");
        lblVencimiento.setBounds(labelX, y += spacing, 150, height);
        add(lblVencimiento);

        cal.set(2026, Calendar.JANUARY, 1);
        SpinnerDateModel modelVencimiento = new SpinnerDateModel(cal.getTime(), null, null, Calendar.DAY_OF_MONTH);
        JSpinner spinnerVencimientoLicencia = new JSpinner(modelVencimiento);
        spinnerVencimientoLicencia.setBounds(fieldX, y, 200, height);
        spinnerVencimientoLicencia.setEditor(new JSpinner.DateEditor(spinnerVencimientoLicencia, "yyyy-MM-dd"));
        add(spinnerVencimientoLicencia);

        JLabel lblUsername = new JLabel("Usuario:");
        lblUsername.setBounds(labelX, y += spacing, 150, height);
        add(lblUsername);
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(fieldX, y, 200, height);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(labelX, y += spacing, 150, height);
        add(lblPassword);
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(fieldX, y, 200, height);
        add(txtPassword);

        JButton btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds(100, y += spacing + 20, 130, 30);
        btnRegistro.addActionListener(e -> registrar(txtNombre, txtApellido, txtEmail, txtDni, txtTelefono, 
        txtDireccion, spinnerNacimiento, txtNumeroLicencia, spinnerVencimientoLicencia, txtUsername, txtPassword));
        add(btnRegistro);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(260, y, 130, 30);
        btnVolver.addActionListener(e -> cancelarRegistro());
        add(btnVolver);
    }

    private void cancelarRegistro() {      
        new Login().setVisible(true);  
        this.dispose();
    }

    private void registrar(JTextField txtNombre, JTextField txtApellido, JTextField txtEmail, JTextField txtDni, 
            JTextField txtTelefono, JTextField txtDireccion, JSpinner spinnerNacimiento, JTextField txtNumeroLicencia,
            JSpinner spinnerVencimientoLicencia, JTextField txtUsername, JPasswordField txtPassword) {
        
        // Validar campos
        ResultadoValidacion resultado = validarTodos(
                validar(txtNombre, TipoInput.TEXTO, "Nombre"),
                validar(txtApellido, TipoInput.TEXTO, "Apellido"),
                validar(txtEmail, TipoInput.EMAIL, "Email"),
                validar(txtDni, TipoInput.NUMERO_ENTERO_POSITIVO, "DNI"),
                validar(txtTelefono, TipoInput.NUMERO_ENTERO_POSITIVO, "Teléfono"),
                validar(txtDireccion, TipoInput.TEXTO, "Dirección"),
                validar(spinnerNacimiento, "Fecha de nacimiento"),
                validar(txtNumeroLicencia, TipoInput.TEXTO, "Número de licencia"),
                validar(spinnerVencimientoLicencia, "Vencimiento de licencia"),
                validar(txtUsername, TipoInput.TEXTO, "Usuario"),
                validar(txtPassword, "Contraseña")
        );

        if (!resultado.valido) {
            JOptionPane.showMessageDialog(this, resultado.mensaje, "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Si todas las validaciones pasan, continuar con el registro
        Respuesta respuesta = clienteController.registrar(
                txtNombre.getText().trim(), 
                txtApellido.getText().trim(), 
                txtEmail.getText().trim(), 
                txtDni.getText().trim(), 
                txtTelefono.getText().trim(), 
                txtDireccion.getText().trim(),
                (Date) spinnerNacimiento.getValue(),
                txtNumeroLicencia.getText().trim(), 
                (Date) spinnerVencimientoLicencia.getValue(), 
                txtUsername.getText().trim(),
                new String(txtPassword.getPassword()));

        if (respuesta.exito) {
            JOptionPane.showMessageDialog(this, "Gracias por registrarse. Ahora puede iniciar sesión utilizando sus datos");
            new Login().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error: " + respuesta.mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}