package firstPg.services;
import firstPg.model.AuthorView;
import firstPg.model.Books;
import firstPg.model.ReaderView;
import firstPg.model.User;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class AuthorReviews extends JFrame {

    private User user;
    private String bookName;

    public AuthorReviews(String bookName) throws FileNotFoundException {
        this.bookName = bookName;
        this.user = user;
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Book reviews");
        setResizable(false);
        setSize(500, 500);
        setLocationRelativeTo(null);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        Color c = Color.pink;
        contentPane.setBackground(c);
        Color cl = Color.lightGray;

        JPanel panel1 = new JPanel();

        panel1.setBounds(0,15,500, 600);
        panel1.setBackground(c);
        contentPane.add(panel1);

        JTable table = new JTable();
        table.setRowHeight(50);
        String readLine = null;
        ReviewsListTableModel tableModel = new ReviewsListTableModel();
        File file = new File("src/main/resources/Reviews");
        FileReader reader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(reader);
        List<String> reviewsList = new ArrayList<String>();

        try {
            while((readLine = bufReader.readLine()) != null) {
                String[] splitData = readLine.split(",");
                if(splitData[0].equals(bookName)){
                    reviewsList.add(splitData[1]);
                }
            }
        } catch(IOException ex) {
        }

        if(reviewsList.isEmpty()){
            JOptionPane.showMessageDialog(null,
                    "There aren't any reviews for this book yet.");
            setVisible(false);
        }else {

            tableModel.setList(reviewsList);
            table.setModel(tableModel);
            setVisible(true);
        }
        Color pink=new Color(255, 230, 235, 255);
        table.setBackground(pink);
        table.getTableHeader().setBackground(c);
        JScrollPane scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(pink);
        panel1.add(scroll);
    }
}