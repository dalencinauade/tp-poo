package alquilervehiculos;

import alquilervehiculos.config.AppContext;
import alquilervehiculos.ui.Login;

public class MainApp {
    public static void main(String[] args) {
        AppContext.init();

        javax.swing.SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
