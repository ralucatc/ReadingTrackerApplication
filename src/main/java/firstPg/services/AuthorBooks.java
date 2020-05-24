package firstPg.services;

import firstPg.model.Books;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class AuthorBooks extends JFrame {
    private JTextField txtAddBook;
    private JButton btnAddBook;
    private JComboBox<String> cmbLibrary;
    private String Title;

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

        String readLine = null;

        BooksListTableModel tableModel = new BooksListTableModel();
        File file = new File("src/main/resources/BooksLibrary");

        FileReader reader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(reader);

        tableModel.setList(booksList);
        table.setModel(tableModel);

        Color pink=new Color(255, 230, 235, 255);
        Color pink_d=new Color(255, 182, 199, 211); // 255,182,193

        table.setBackground(pink);
        table.getTableHeader().setBackground(pink_d);

        JScrollPane scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(pink_d);
        frame.add(scroll);
    }
}


