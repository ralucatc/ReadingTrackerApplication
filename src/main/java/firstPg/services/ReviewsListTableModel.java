package firstPg.services;

import firstPg.model.Books;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ReviewsListTableModel extends AbstractTableModel {

    private List<Books> list = new ArrayList<Books>();
    private String[] columnNames = {"Reviews"};

    public void setList(List<Books> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }
}

