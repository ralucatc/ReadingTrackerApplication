package firstPg.services;

import firstPg.model.Books;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class BooksListTableModel extends AbstractTableModel {

    private List<Books> list = new ArrayList<Books>();
    private String[] columnNames = {"Title", "Author", "Year of publication", "Summary"};

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

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getTitle();
            case 1:
                return list.get(rowIndex).getAuthor();
            case 2:
                return list.get(rowIndex).getPublicationYear();
            case 3:
                return list.get(rowIndex).getDescription();
            default:
                return null;
        }
    }
}

