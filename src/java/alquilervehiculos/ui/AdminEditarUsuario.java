package alquilervehiculos.ui;

import javax.swing.*;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.AdministrativoController;
import alquilervehiculos.controller.ClienteController;
import alquilervehiculos.controller.GerenteController;
import alquilervehiculos.controller.TecnicoController;
import alquilervehiculos.controller.UsuarioController;
import alquilervehiculos.model.dto.ObtenerUsuarioParaEdicionDTO;
import alquilervehiculos.model.entities.Respuesta;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class AdminEditarUsuario extends JDialog {
    private final UsuarioController usuarioController;
    private final AdministrativoController administrativoController;
    private final ClienteController clienteController;
    private final TecnicoController tecnicoController;
    private final GerenteController gerenteController;

    private JTextField txtNombre, txtApellido, txtEmail, txtDni, txtTelefono, txtDireccion;
    private JSpinner spinnerNacimiento;

    private JLabel lblLegajo, lblSalario, lblMetaAlquileresMensual, lblIdiomas, lblBonoRendimiento, lblInicioComoGerente, lblMetaVentasMensual, lblNumeroLicencia, lblVencimientoLicencia;
    private JTextField txtLegajo, txtSalario, txtMetaAlquileresMensual, txtIdiomas, txtBonoRendimiento, txtMetaVentasMensual, txtNumeroLicencia;
    private JSpinner spinnerInicioComoGerente, spinnerVencimientoLicencia;

    private JButton btnEditar, btnCancelar;

    private String rol;
    private int idUsuario;

    public AdminEditarUsuario(Dialog parent, boolean modal, int idUsuario) {
        super(parent, modal);
        setTitle("Editar Usuario");

        this.usuarioController = AppContext.getUsuarioController();
        this.administrativoController = AppContext.getAdministrativoController();
        this.clienteController = AppContext.getClienteController();
        this.tecnicoController = AppContext.getTecnicoController();
        this.gerenteController = AppContext.getGerenteController();
        
        this.idUsuario = idUsuario;

        init();
        cargarDatosUsuario(idUsuario);
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
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(labelX, y, 150, height);
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

        // Botones
        btnEditar = new JButton("Editar");
        btnEditar.addActionListener(e -> editar());
        add(btnEditar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> cancelar());
        add(btnCancelar);
    }

    private void refrescarCamposPorRol() {
        JLabel[] labels = {lblLegajo, lblSalario, lblMetaAlquileresMensual, lblIdiomas, lblBonoRendimiento, lblInicioComoGerente, lblMetaVentasMensual, lblNumeroLicencia, lblVencimientoLicencia};
        JComponent[] fields = {txtLegajo, txtSalario, txtMetaAlquileresMensual, txtIdiomas, txtBonoRendimiento, spinnerInicioComoGerente, txtMetaVentasMensual, txtNumeroLicencia, spinnerVencimientoLicencia};

        for (int i = 0; i < labels.length; i++) {
            labels[i].setVisible(false);
            fields[i].setVisible(false);
        }

        int labelX = 50, fieldX = 250;
        int y = 300;
        int spacing = 35;

        switch (rol) {
            case "CLIENTE" -> {
                mostrar(lblNumeroLicencia, txtNumeroLicencia, labelX, fieldX, y);
                mostrar(lblVencimientoLicencia, spinnerVencimientoLicencia, labelX, fieldX, y += spacing);
                y += spacing;
            }

            case "ADMINISTRATIVO" -> {
                mostrar(lblLegajo, txtLegajo, labelX, fieldX, y);
                mostrar(lblSalario, txtSalario, labelX, fieldX, y += spacing);
                mostrar(lblMetaAlquileresMensual, txtMetaAlquileresMensual, labelX, fieldX, y += spacing);
                mostrar(lblIdiomas, txtIdiomas, labelX, fieldX, y += spacing);
                y += spacing;
            }

            case "TECNICO" -> {
                mostrar(lblLegajo, txtLegajo, labelX, fieldX, y);
                mostrar(lblSalario, txtSalario, labelX, fieldX, y += spacing);
                y += spacing;
            }

            case "GERENTE" -> {
                mostrar(lblLegajo, txtLegajo, labelX, fieldX, y);
                mostrar(lblSalario, txtSalario, labelX, fieldX, y += spacing);
                mostrar(lblBonoRendimiento, txtBonoRendimiento, labelX, fieldX, y += spacing);
                mostrar(lblInicioComoGerente, spinnerInicioComoGerente, labelX, fieldX, y += spacing);
                mostrar(lblMetaVentasMensual, txtMetaVentasMensual, labelX, fieldX, y += spacing);
                y += spacing;
            }
        }

        btnEditar.setBounds(110, y + 40, 120, 30);
        btnCancelar.setBounds(270, y + 40, 120, 30);
        setSize(520, y + 150);
        repaint();
    }

    private void mostrar(JLabel label, JComponent field, int lx, int fx, int y) {
        label.setBounds(lx, y, 200, 25);
        field.setBounds(fx, y, 200, 25);
        label.setVisible(true);
        field.setVisible(true);
    }

    private void cargarDatosUsuario(int idUsuario) {
        ObtenerUsuarioParaEdicionDTO usuarioDTO = usuarioController.obtenerParaEdicion(idUsuario);

        if (usuarioDTO != null) {
            this.rol = usuarioDTO.getRol();

            txtNombre.setText(usuarioDTO.getNombre());
            txtApellido.setText(usuarioDTO.getApellido());
            txtEmail.setText(usuarioDTO.getEmail());
            txtDni.setText(usuarioDTO.getDni());
            txtTelefono.setText(usuarioDTO.getTelefono());
            txtDireccion.setText(usuarioDTO.getDireccion());
            spinnerNacimiento.setValue(usuarioDTO.getFechaNacimiento());
            txtLegajo.setText(String.valueOf(usuarioDTO.getLegajo()));
            txtSalario.setText(String.valueOf(usuarioDTO.getSalario()));

            switch (rol) {
                case "CLIENTE" -> {
                    txtNumeroLicencia.setText(usuarioDTO.getNumeroLicencia());
                    spinnerVencimientoLicencia.setValue(usuarioDTO.getFechaVencimientoLicencia());
                }

                case "ADMINISTRATIVO" -> {
                    txtMetaAlquileresMensual.setText(String.valueOf(usuarioDTO.getMetaAlquileresMensual()));
                    txtIdiomas.setText(usuarioDTO.getIdiomas());
                }

                case "TECNICO" -> {
                    
                }

                case "GERENTE" -> {
                    txtBonoRendimiento.setText(String.valueOf(usuarioDTO.getBonoRendimiento()));
                    spinnerInicioComoGerente.setValue(usuarioDTO.getFechaInicioComoGerente());
                    txtMetaVentasMensual.setText(String.valueOf(usuarioDTO.getMetaVentasMensual()));
                }
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Error al obtener el usuario", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }

        refrescarCamposPorRol();
    }

    private void editar() {
        Respuesta respuesta = new Respuesta(false, "");

        switch (rol) {
            case "CLIENTE" -> {
                respuesta = clienteController.editar(this.idUsuario, txtNombre.getText(), txtApellido.getText(),
                txtEmail.getText(), txtDni.getText(), txtTelefono.getText(), txtDireccion.getText(),
                (Date) spinnerNacimiento.getValue(), txtNumeroLicencia.getText(), (Date) spinnerVencimientoLicencia.getValue());
            }

            case "ADMINISTRATIVO" -> {
                respuesta = administrativoController.editar(this.idUsuario, txtNombre.getText(), txtApellido.getText(),
                txtEmail.getText(), txtDni.getText(), txtTelefono.getText(), txtDireccion.getText(),
                (Date) spinnerNacimiento.getValue(), txtLegajo.getText(), Double.parseDouble(txtSalario.getText()),
                Integer.parseInt(txtMetaAlquileresMensual.getText()), txtIdiomas.getText());
            }

            case "TECNICO" -> {
                respuesta = tecnicoController.editar(this.idUsuario, txtNombre.getText(), txtApellido.getText(),
                txtEmail.getText(), txtDni.getText(), txtTelefono.getText(), txtDireccion.getText(),
                (Date) spinnerNacimiento.getValue(), txtLegajo.getText(), Double.parseDouble(txtSalario.getText()));
            }

            case "GERENTE" -> {
                respuesta = gerenteController.editar(this.idUsuario, txtNombre.getText(), txtApellido.getText(),
                txtEmail.getText(), txtDni.getText(), txtTelefono.getText(), txtDireccion.getText(),
                (Date) spinnerNacimiento.getValue(), txtLegajo.getText(), Double.parseDouble(txtSalario.getText()),
                Double.parseDouble(txtBonoRendimiento.getText()), (Date) spinnerInicioComoGerente.getValue(),
                Double.parseDouble(txtMetaVentasMensual.getText()));
            }
        }

        if (respuesta.exito) {
            JOptionPane.showMessageDialog(this, "Usuario editado correctamente");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error: " + respuesta.mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelar() {
        this.dispose();
    }
}
