package firstPg.services;
;
import firstPg.model.Books;
import firstPg.model.ReaderView;
import firstPg.model.User;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class AddBookWantLibrary extends JFrame {
    
    private User user;

    public AddBookWantLibrary(User user) throws FileNotFoundException {

        this.user = user;
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Want to Read Library");
        setResizable(false);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ReaderView view = new ReaderView(user);
                view.setVisible(true);
                dispose();
            }
        });

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        Color c = Color.pink;
        contentPane.setBackground(c);
        Color cl = Color.lightGray;

        JPanel panel1 = new JPanel();// top panel

        panel1.setBounds(0,15,500, 600);
        panel1.setBackground(c);
        contentPane.add(panel1);

        JTable table = new JTable();
        String readLine = null;
        BooksListTableModel tableModel = new BooksListTableModel();
        File file = new File("src/main/resources/WantToReadLibrary");
        FileReader reader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(reader);
        List<Books> booksList = new ArrayList<>();

        try {
            while((readLine = bufReader.readLine()) != null) {
                String[] splitData = readLine.split(",");
                String userID = splitData[4];
                if (userID.trim().equals(String.valueOf(user.getID()))) {
                    Books book = new Books();
                    book.setTitle(splitData[0]);
                    book.setAuthor(splitData[1]);
                    book.setPublicationYear(splitData[2]);
                    book.setDescription(splitData[3]);
                    booksList.add(book);
                }
            }
        } catch(IOException ex) {}

        tableModel.setList(booksList);
        table.setModel(tableModel);

        Color pink=new Color(255, 230, 235, 255);
        table.setBackground(pink);
        table.getTableHeader().setBackground(c);
        JScrollPane scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(pink);
        panel1.add(scroll);
    }
}