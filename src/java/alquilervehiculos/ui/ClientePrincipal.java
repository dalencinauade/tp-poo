package alquilervehiculos.ui;

import javax.swing.*;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.ClienteController;
import alquilervehiculos.controller.UsuarioController;
import alquilervehiculos.model.dto.ClienteObtenerDatosInterfazDTO;
import alquilervehiculos.model.enums.EstadoAlquilerEnum;
import alquilervehiculos.model.enums.EstadoReservaEnum;

public class ClientePrincipal extends JFrame {
    private final UsuarioController usuarioController;
    private final ClienteController clienteController;

    private JButton btnReservar;

    public ClientePrincipal() {
        super("Panel principal");
        this.usuarioController = AppContext.getUsuarioController();
        this.clienteController = AppContext.getClienteController();
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

        btnReservar = new JButton("Reservar vehículo");
        btnReservar.setBounds(20, 50, 200, 25);
        btnReservar.addActionListener(e -> reservar());
        add(btnReservar);

        JButton btnLogout = new JButton("Cerrar sesión");
        btnLogout.setBounds(20, 110, 200, 25);
        btnLogout.addActionListener(e -> logout());
        add(btnLogout);

        obtenerDatosInterfaz();
    }

    private void logout() {
        usuarioController.logout();
        JOptionPane.showMessageDialog(this, "Sesión cerrada!");
        new Login().setVisible(true);
        this.dispose();
    }

    private void obtenerDatosInterfaz() {
        ClienteObtenerDatosInterfazDTO dto = clienteController.obtenerDatosInterfaz(usuarioController.getSesionActual().getId());

        if (dto.getEstadoReserva() != EstadoReservaEnum.PENDIENTE && dto.getEstadoAlquiler() != EstadoAlquilerEnum.VIGENTE) {
            btnReservar.setVisible(true);
        }

        
    }

    private void reservar() {
        new ClienteReservarVehiculo(this, true).setVisible(true);
    }
}