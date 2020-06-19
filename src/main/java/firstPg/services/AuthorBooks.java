package firstPg.services;
import firstPg.model.Books;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class AuthorBooks extends JFrame {

    public AuthorBooks(ArrayList<Books> booksList) throws FileNotFoundException {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("All the books added in the application");
        frame.setResizable(false);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JTable table = new JTable();
        BooksListTableModel tableModel = new BooksListTableModel();
        tableModel.setList(booksList);
        table.setModel(tableModel);
        Color pink=new Color(255, 230, 235, 255);
        Color pink_d=new Color(255, 182, 199, 211); // 255,182,193

        table.setBackground(pink);
        table.getTableHeader().setBackground(pink_d);

        JScrollPane scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(pink_d);
        frame.add(scroll);

        table.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String selectedData = null;

                int[] selectedRow = table.getSelectedRows();
                int[] selectedColumns = table.getSelectedColumns();

                if (selectedColumns[0] == 0) {
                    selectedData = (String) table.getValueAt(selectedRow[0], selectedColumns[0]);
                    int a = JOptionPane.showConfirmDialog(null, "Do you want to see the reviews?", "Select an Option...",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (a == 0) {
                        try {
                            AuthorReviews reviews = new AuthorReviews(selectedData);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

            }
        });
    }
}
