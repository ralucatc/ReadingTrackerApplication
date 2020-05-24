package firstPg.services;

import firstPg.model.Books;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BooksListTableModel2 extends AbstractTableModel {

    private List<Books> list = new ArrayList<Books>();
    private static final String[] columnNames = new String[] {"Title", "Progress"};
    private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class,  JButton.class};

    public void setList(List<Books> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_TYPES[columnIndex];
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getTitle();
            case 1: final JButton button = new JButton(columnNames[columnIndex]);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    JOptionPane.showMessageDialog(null, "Progress");
                }
            });
            return button;
            default:
                return null;
        }
    }
}

