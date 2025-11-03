package alquilervehiculos.ui;

import javax.swing.*;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.AdministrativoController;
import alquilervehiculos.controller.ClienteController;
import alquilervehiculos.controller.GerenteController;
import alquilervehiculos.controller.TecnicoController;
import alquilervehiculos.model.entities.Respuesta;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class AdminCrearUsuario extends JDialog {
    private final AdministrativoController administrativoController;
    private final ClienteController clienteController;
    private final TecnicoController tecnicoController;
    private final GerenteController gerenteController;

    private JComboBox<String> cmbRol;

    private JTextField txtNombre, txtApellido, txtEmail, txtDni, txtTelefono, txtDireccion, txtUsername;
    private JPasswordField txtPassword;
    private JSpinner spinnerNacimiento;

    private JLabel lblLegajo, lblSalario, lblMetaAlquileresMensual, lblIdiomas, lblBonoRendimiento, lblInicioComoGerente, lblMetaVentasMensual, lblNumeroLicencia, lblVencimientoLicencia;
    private JTextField txtLegajo, txtSalario, txtMetaAlquileresMensual, txtIdiomas, txtBonoRendimiento, txtMetaVentasMensual, txtNumeroLicencia;
    private JSpinner spinnerInicioComoGerente, spinnerVencimientoLicencia;

    private JButton btnRegistrar, btnCancelar;

    public AdminCrearUsuario(Dialog parent, boolean modal) {
        super(parent, modal);
        setTitle("Crear Usuario");

        this.administrativoController = AppContext.getAdministrativoController();
        this.clienteController = AppContext.getClienteController();
        this.tecnicoController = AppContext.getTecnicoController();
        this.gerenteController = AppContext.getGerenteController();
        
        init();
    }

    private void init() {
        setLayout(null);
        setSize(520, 850);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        int labelX = 50;
        int fieldX = 250;
        int y = 30;
        int height = 25;
        int spacing = 35;
        Calendar cal = Calendar.getInstance();

        // Campos comunes
        JLabel lblRol = new JLabel("Rol:");
        lblRol.setBounds(labelX, y, 150, height);
        cmbRol = new JComboBox<>(new String[]{"Administrativo", "Técnico", "Gerente", "Cliente"});
        cmbRol.setBounds(fieldX, y, 200, height);
        add(lblRol);
        add(cmbRol);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(labelX, y += spacing, 150, height);
        txtNombre = new JTextField();
        txtNombre.setBounds(fieldX, y, 200, height);
        add(lblNombre);
        add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(labelX, y += spacing, 150, height);
        txtApellido = new JTextField();
        txtApellido.setBounds(fieldX, y, 200, height);
        add(lblApellido);
        add(txtApellido);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(labelX, y += spacing, 150, height);
        txtEmail = new JTextField();
        txtEmail.setBounds(fieldX, y, 200, height);
        add(lblEmail);
        add(txtEmail);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(labelX, y += spacing, 150, height);
        txtDni = new JTextField();
        txtDni.setBounds(fieldX, y, 200, height);
        add(lblDni);
        add(txtDni);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(labelX, y += spacing, 150, height);
        txtTelefono = new JTextField();
        txtTelefono.setBounds(fieldX, y, 200, height);
        add(lblTelefono);
        add(txtTelefono);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(labelX, y += spacing, 150, height);
        txtDireccion = new JTextField();
        txtDireccion.setBounds(fieldX, y, 200, height);
        add(lblDireccion);
        add(txtDireccion);

        JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
        lblFechaNacimiento.setBounds(labelX, y += spacing, 150, height);
        cal.set(2000, Calendar.JANUARY, 1);
        spinnerNacimiento = new JSpinner(new SpinnerDateModel(cal.getTime(), null, null, Calendar.DAY_OF_MONTH));
        spinnerNacimiento.setEditor(new JSpinner.DateEditor(spinnerNacimiento, "yyyy-MM-dd"));
        spinnerNacimiento.setBounds(fieldX, y, 200, height);
        add(lblFechaNacimiento);
        add(spinnerNacimiento);

        JLabel lblUsername = new JLabel("Usuario:");
        lblUsername.setBounds(labelX, y += spacing, 150, height);
        txtUsername = new JTextField();
        txtUsername.setBounds(fieldX, y, 200, height);
        add(lblUsername);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(labelX, y += spacing, 150, height);
        txtPassword = new JPasswordField();
        txtPassword.setBounds(fieldX, y, 200, height);
        add(lblPassword);
        add(txtPassword);

        // Roles específicos
        lblLegajo = new JLabel("Legajo:");
        lblLegajo.setBounds(labelX, y += spacing, 150, height);
        txtLegajo = new JTextField();
        txtLegajo.setBounds(fieldX, y, 200, height);
        add(lblLegajo);
        add(txtLegajo);

        lblSalario = new JLabel("Salario:");
        lblSalario.setBounds(labelX, y += spacing, 150, height);
        txtSalario = new JTextField();
        txtSalario.setBounds(fieldX, y, 200, height);
        add(lblSalario);
        add(txtSalario);

        lblMetaAlquileresMensual = new JLabel("Meta de alquileres mensual:");
        lblMetaAlquileresMensual.setBounds(labelX, y += spacing, 200, height);
        txtMetaAlquileresMensual = new JTextField();
        txtMetaAlquileresMensual.setBounds(fieldX, y, 200, height);
        add(lblMetaAlquileresMensual);
        add(txtMetaAlquileresMensual);

        lblIdiomas = new JLabel("Idiomas:");
        lblIdiomas.setBounds(labelX, y += spacing, 200, height);
        txtIdiomas = new JTextField();
        txtIdiomas.setBounds(fieldX, y, 200, height);
        add(lblIdiomas);
        add(txtIdiomas);

        lblBonoRendimiento = new JLabel("Bono por rendimiento:");
        lblBonoRendimiento.setBounds(labelX, y += spacing, 200, height);
        txtBonoRendimiento = new JTextField();
        txtBonoRendimiento.setBounds(fieldX, y, 200, height);
        add(lblBonoRendimiento);
        add(txtBonoRendimiento);

        lblInicioComoGerente = new JLabel("Fecha inicio como gerente:");
        lblInicioComoGerente.setBounds(labelX, y += spacing, 200, height);
        spinnerInicioComoGerente = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
        spinnerInicioComoGerente.setEditor(new JSpinner.DateEditor(spinnerInicioComoGerente, "yyyy-MM-dd"));
        spinnerInicioComoGerente.setBounds(fieldX, y, 200, height);
        add(lblInicioComoGerente);
        add(spinnerInicioComoGerente);

        lblMetaVentasMensual = new JLabel("Meta de ventas mensual:");
        lblMetaVentasMensual.setBounds(labelX, y += spacing, 200, height);
        txtMetaVentasMensual = new JTextField();
        txtMetaVentasMensual.setBounds(fieldX, y, 200, height);
        add(lblMetaVentasMensual);
        add(txtMetaVentasMensual);

        lblNumeroLicencia = new JLabel("Número de licencia:");
        lblNumeroLicencia.setBounds(labelX, y += spacing, 200, height);
        txtNumeroLicencia = new JTextField();
        txtNumeroLicencia.setBounds(fieldX, y, 200, height);
        add(lblNumeroLicencia);
        add(txtNumeroLicencia);

        lblVencimientoLicencia = new JLabel("Vencimiento de licencia:");
        lblVencimientoLicencia.setBounds(labelX, y += spacing, 200, height);
        spinnerVencimientoLicencia = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
        spinnerVencimientoLicencia.setEditor(new JSpinner.DateEditor(spinnerVencimientoLicencia, "yyyy-MM-dd"));
        spinnerVencimientoLicencia.setBounds(fieldX, y, 200, height);
        add(lblVencimientoLicencia);
        add(spinnerVencimientoLicencia);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(e -> registrar(txtNombre.getText(), txtApellido.getText(), txtEmail.getText(),
        txtDni.getText(), txtTelefono.getText(), txtDireccion.getText(), (Date)spinnerNacimiento.getValue(),
        txtUsername.getText(), new String(txtPassword.getPassword()), txtLegajo.getText(), txtSalario.getText(),
        (String) cmbRol.getSelectedItem(), txtMetaAlquileresMensual.getText(), txtIdiomas.getText(),
        txtBonoRendimiento.getText(), (Date)spinnerInicioComoGerente.getValue(), txtMetaVentasMensual.getText(),
        txtNumeroLicencia.getText(), (Date)spinnerVencimientoLicencia.getValue()));
        add(btnRegistrar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> cancelar());
        add(btnCancelar);

        cmbRol.addActionListener(e -> refrescarCampos());
        refrescarCampos();
    }

    private void refrescarCampos() {
        String rol = (String) cmbRol.getSelectedItem();

        // Ocultamos todos los específicos
        JLabel[] labels = {lblLegajo, lblSalario, lblMetaAlquileresMensual, lblIdiomas, lblBonoRendimiento, lblInicioComoGerente, lblMetaVentasMensual, lblNumeroLicencia, lblVencimientoLicencia};
        JComponent[] fields = {txtLegajo, txtSalario, txtMetaAlquileresMensual, txtIdiomas, txtBonoRendimiento, spinnerInicioComoGerente, txtMetaVentasMensual, txtNumeroLicencia, spinnerVencimientoLicencia};

        for (int i = 0; i < labels.length; i++) {
            labels[i].setVisible(false);
            fields[i].setVisible(false);
        }

        int labelX = 50, fieldX = 250;
        int y = 400; // Altura desde los campos comunes
        int spacing = 35;

        switch (rol) {
            case "Cliente" -> {
                mostrar(lblNumeroLicencia, txtNumeroLicencia, labelX, fieldX, y);
                mostrar(lblVencimientoLicencia, spinnerVencimientoLicencia, labelX, fieldX, y += spacing);
                y += spacing;
            }

            case "Administrativo" -> {
                mostrar(lblLegajo, txtLegajo, labelX, fieldX, y);
                mostrar(lblSalario, txtSalario, labelX, fieldX, y += spacing);
                mostrar(lblMetaAlquileresMensual, txtMetaAlquileresMensual, labelX, fieldX, y += spacing);
                mostrar(lblIdiomas, txtIdiomas, labelX, fieldX, y += spacing);
                y += spacing;
            }

            case "Técnico" -> {
                mostrar(lblLegajo, txtLegajo, labelX, fieldX, y);
                mostrar(lblSalario, txtSalario, labelX, fieldX, y += spacing);
                y += spacing;
            }

            case "Gerente" -> {
                mostrar(lblLegajo, txtLegajo, labelX, fieldX, y);
                mostrar(lblSalario, txtSalario, labelX, fieldX, y += spacing);
                mostrar(lblBonoRendimiento, txtBonoRendimiento, labelX, fieldX, y += spacing);
                mostrar(lblInicioComoGerente, spinnerInicioComoGerente, labelX, fieldX, y += spacing);
                mostrar(lblMetaVentasMensual, txtMetaVentasMensual, labelX, fieldX, y += spacing);
                y += spacing;
            }
        }

        // Botones
        btnRegistrar.setBounds(110, y + 40, 120, 30);
        btnCancelar.setBounds(270, y + 40, 120, 30);

        // Ajustar tamaño dinámico
        setSize(520, y + 150);
        repaint();
    }

    private void mostrar(JLabel label, JComponent field, int lx, int fx, int y) {
        label.setBounds(lx, y, 200, 25);
        field.setBounds(fx, y, 200, 25);
        label.setVisible(true);
        field.setVisible(true);
    }

    private void cancelar() {
        this.dispose();
    }

    private void registrar(String nombre, String apellido, String email, String dni, String telefono, String direccion,
    Date fechaNacimiento,  String username, String password, String legajo, String salario, String rol,
    String metaAlquileresMensual, String idiomas, String bonoRendimiento, Date fechaInicioComoGerente,
    String metaVentas, String numeroLicencia, Date fechaVencimientoLicencia) {

        Respuesta respuesta = new Respuesta(false, "");

        switch (rol) {
            case "Administrativo" -> {
                respuesta = administrativoController.registrar(nombre, apellido, email, dni, telefono, direccion,
                fechaNacimiento, username, password, legajo, salario, metaAlquileresMensual, idiomas);
            }

            case "Técnico" -> {
                respuesta = tecnicoController.registrar(nombre, apellido, email, dni, telefono, direccion,
                fechaNacimiento, username, password, legajo, salario);
            }

            case "Gerente" -> {
                respuesta = gerenteController.registrar(nombre, apellido, email, dni, telefono, direccion,
                fechaNacimiento, username, password, legajo, salario, bonoRendimiento, fechaInicioComoGerente, metaVentas);
            }

            case "Cliente" -> {
                respuesta = clienteController.registrar(nombre, apellido, email, dni, telefono, direccion,
                fechaNacimiento, numeroLicencia, fechaVencimientoLicencia, username, password);
            }
        }

        if (respuesta.exito) {
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error: " + respuesta.mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
