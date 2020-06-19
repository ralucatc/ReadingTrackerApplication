package firstPg.services;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ReviewsListTableModel extends AbstractTableModel {

    private List<String> list = new ArrayList<String>();
    private String[] columnNames = {"Reviews"};

    public void setList(List<String> list) {
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
                return list.get(rowIndex);
            default:
                return null;
        }
    }
}



