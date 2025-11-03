package alquilervehiculos.ui.components;

import javax.swing.*;
import java.awt.*;

public class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {
    
    public ButtonRenderer() {
        setOpaque(true);
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}