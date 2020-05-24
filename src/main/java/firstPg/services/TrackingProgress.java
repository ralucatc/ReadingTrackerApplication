package firstPg.services;

import firstPg.model.Books;
import firstPg.model.ReaderView;
import firstPg.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TrackingProgress extends JFrame {

    private User user;

    public TrackingProgress(User user) throws FileNotFoundException {
        this.user=user;
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Want to Read Library ");
        frame.setResizable(false);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ReaderView view = new ReaderView(user);
                view.setVisible(true);
                dispose();
            }
        });

        JTable table = new JTable();

        String readLine = null;

        BooksListTableModel2 tableModel = new BooksListTableModel2();
        File file = new File("src/main/resources/CurrentlyReadingLibrary");

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
                    booksList.add(book);
                }
            }
        } catch(IOException ex) {}

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
