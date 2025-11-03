package alquilervehiculos.ui.components;

import java.awt.*;
import javax.swing.*;

public class ButtonEditor extends DefaultCellEditor {
    private final JButton button;
    private boolean clicked;
    private int row;
    private final TableButtonAction action;

    public ButtonEditor(JCheckBox checkBox, TableButtonAction action) {
        super(checkBox);
        this.action = action;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int col) {
        button.setText(value == null ? "" : value.toString());
        this.row = row;
        clicked = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (clicked && action != null) {
            action.onClick(row);
        }

        clicked = false;
        return button.getText();
    }
}