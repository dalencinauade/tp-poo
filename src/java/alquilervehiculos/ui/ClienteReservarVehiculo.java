package alquilervehiculos.ui;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.controller.ReservaController;
import alquilervehiculos.controller.UsuarioController;
import alquilervehiculos.controller.VehiculoController;
import alquilervehiculos.model.dto.ListarVehiculosDisponiblesDTO;
import alquilervehiculos.ui.components.ButtonEditor;
import alquilervehiculos.ui.components.ButtonRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ClienteReservarVehiculo extends JDialog {

    private VehiculoController vehiculoController;
    private ReservaController reservaController;
    private UsuarioController usuarioController;

    private JSpinner spinnerDesde, spinnerHasta;
    private JButton btnConsultar, btnVolver, btnConfirmar;
    private JTable tablaVehiculos;
    private DefaultTableModel modeloTabla;
    private JLabel lblResumen;

    private JScrollPane scrollTabla;

    private int idVehiculoSeleccionado = -1;
    private double costoEstimado = 0;
    private Date desdeFinal, hastaFinal;

    public ClienteReservarVehiculo(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Reservar Vehículo");

        this.vehiculoController = AppContext.getVehiculoController();
        this.reservaController = AppContext.getReservaController();
        this.usuarioController = AppContext.getUsuarioController();

        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(750, 250);
        setResizable(false);
        setLocationRelativeTo(null);

        JLabel lblDesde = new JLabel("Fecha desde:");
        lblDesde.setBounds(30, 30, 120, 25);
        add(lblDesde);

        spinnerDesde = new JSpinner(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH));
        spinnerDesde.setEditor(new JSpinner.DateEditor(spinnerDesde, "yyyy-MM-dd"));
        spinnerDesde.setBounds(150, 30, 150, 25);
        add(spinnerDesde);

        JLabel lblHasta = new JLabel("Fecha hasta:");
        lblHasta.setBounds(320, 30, 120, 25);
        add(lblHasta);

        spinnerHasta = new JSpinner(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH));
        spinnerHasta.setEditor(new JSpinner.DateEditor(spinnerHasta, "yyyy-MM-dd"));
        spinnerHasta.setBounds(430, 30, 150, 25);
        add(spinnerHasta);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(600, 30, 100, 25);
        btnConsultar.addActionListener(e -> consultarDisponibilidad());
        add(btnConsultar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(30, 70, 150, 30);
        btnVolver.addActionListener(e -> volver());
        add(btnVolver);
    }

    private void consultarDisponibilidad() {
        Date desde = (Date) spinnerDesde.getValue();
        Date hasta = (Date) spinnerHasta.getValue();

        List<ListarVehiculosDisponiblesDTO> lista = vehiculoController.listarDisponibles(desde, hasta);

        if (scrollTabla != null) remove(scrollTabla);
        if (lblResumen != null) remove(lblResumen);
        if (btnConfirmar != null) remove(btnConfirmar);

        String[] columnas = {"ID", "Marca", "Modelo", "Año", "Precio Diario", "Categoría", "Acción"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override public boolean isCellEditable(int row, int col) { return col == 6; }
        };

        for (ListarVehiculosDisponiblesDTO v : lista) {
            modeloTabla.addRow(new Object[]{
                v.getId(),
                v.getMarca(),
                v.getModelo(),
                v.getAnio(),
                v.getPrecioDiario(),
                v.getCategoria(),
                "Seleccionar"
            });
        }

        tablaVehiculos = new JTable(modeloTabla);
        tablaVehiculos.setRowHeight(25);
        tablaVehiculos.getColumn("Acción").setCellRenderer(new ButtonRenderer());
        tablaVehiculos.getColumn("Acción").setCellEditor(
            new ButtonEditor(new JCheckBox(), row -> seleccionarVehiculo(row))
        );

        scrollTabla = new JScrollPane(tablaVehiculos);
        scrollTabla.setBounds(30, 80, 670, 100);
        add(scrollTabla);

        tablaVehiculos.removeColumn(tablaVehiculos.getColumn("ID"));

        btnVolver.setBounds(30, 190, 150, 30);

        setSize(750, 350);
        repaint();
    }

    private void seleccionarVehiculo(int row) {
        idVehiculoSeleccionado = (int) modeloTabla.getValueAt(row, 0);
        double precioDiario = (double) modeloTabla.getValueAt(row, 4);
        desdeFinal = (Date) spinnerDesde.getValue();
        hastaFinal = (Date) spinnerHasta.getValue();

        Calendar calDesde = Calendar.getInstance();
        calDesde.setTime(desdeFinal);
        calDesde.set(Calendar.HOUR_OF_DAY, 0);
        calDesde.set(Calendar.MINUTE, 0);
        calDesde.set(Calendar.SECOND, 0);
        calDesde.set(Calendar.MILLISECOND, 0);

        Calendar calHasta = Calendar.getInstance();
        calHasta.setTime(hastaFinal);
        calHasta.set(Calendar.HOUR_OF_DAY, 0);
        calHasta.set(Calendar.MINUTE, 0);
        calHasta.set(Calendar.SECOND, 0);
        calHasta.set(Calendar.MILLISECOND, 0);

        long diferencia = ((calHasta.getTimeInMillis() - calDesde.getTimeInMillis()) / (1000 * 60 * 60 * 24)) + 1;

        if (diferencia < 1) diferencia = 1;
        costoEstimado = precioDiario * diferencia;

        if (lblResumen != null) remove(lblResumen);
        if (btnConfirmar != null) remove(btnConfirmar);

        lblResumen = new JLabel("TODO: Mostrar info completa vehículo. Reserva seleccionada: Vehículo ID " + idVehiculoSeleccionado + " | Total estimado: $" + costoEstimado);
        lblResumen.setBounds(30, 200, 600, 25);
        add(lblResumen);

        btnConfirmar = new JButton("Confirmar reserva");
        btnConfirmar.setBounds(30, 240, 150, 30);
        btnConfirmar.addActionListener(e -> confirmarReserva());
        add(btnConfirmar);

        btnVolver.setBounds(200, 240, 150, 30);

        setSize(750, 350);
        repaint();
    }

    private void confirmarReserva() {
        if (idVehiculoSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un vehículo primero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        reservaController.confirmar(idVehiculoSeleccionado, usuarioController.getSesionActual().getId(), desdeFinal, hastaFinal, costoEstimado);
        JOptionPane.showMessageDialog(this, "Reserva confirmada con éxito! Acérquese a la sucursal para retirar el vehículo en la fecha indicada");
        dispose();
    }

    private void volver() {
        this.dispose();
    }
}
