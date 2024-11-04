package Formatos;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ImageRenderer extends JLabel implements TableCellRenderer {

    public ImageRenderer() {
        setOpaque(true); // Permitir que el fondo sea visible
    }


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof ImageIcon) {
            setIcon((ImageIcon) value);
            setText(null); // No mostrar texto
        } else {
            setIcon(null);
            setText(value != null ? value.toString() : "");
        }

        // Cambiar el color de fondo si la fila está seleccionada
        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        } else {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }
        return this;
    }//Fin metodo
    
}//Fin clase
