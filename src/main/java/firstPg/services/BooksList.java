package firstPg.services;

import firstPg.controller.firstPgControllers;
import firstPg.exceptions.BookDoesNotExistException;
import firstPg.model.Books;
import firstPg.model.ReaderView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.*;

public class BooksList extends JFrame {

    private JTextField txtAddBook;
    private JButton btnAddBook;
    private JComboBox<String> cmbLibrary;

    public boolean checkExistanceOfBooks (String title)
    {
        try {
            UserService.SearchBooks(title);
            return true;
        } catch (BookDoesNotExistException e) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public BooksList() throws FileNotFoundException {

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("All the books added in the application");
        frame.setResizable(false);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ReaderView view = new ReaderView();
                view.setVisible(true);
                dispose();
            }
        });

        JTable table = new JTable();

        String readLine = null;

        BooksListTableModel tableModel = new BooksListTableModel();
        File file = new File("src/main/resources/BooksLibrary");

        FileReader reader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(reader);

        List<Books> booksList = new ArrayList<>();
        
        try {
            while((readLine = bufReader.readLine()) != null) {
                String[] splitData = readLine.split(",");
                Books book = new Books();
                book.setTitle(splitData[0]);
                book.setAuthor(splitData[1]);
                book.setPublicationYear(splitData[2]);
                book.setDescription(splitData[3]);
                booksList.add(book);
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

       txtAddBook = new JTextField();
       txtAddBook.setBounds(10, 450, 220, 25);
       txtAddBook.setBackground(Color.white);
       scroll.add(txtAddBook);

        String[] library = { "Want to read Library", "Currently reading Library"};
        cmbLibrary = new JComboBox<>(library);
        cmbLibrary.setBounds(10, 500, 220, 25);
        cmbLibrary.setBackground(Color.white);
        scroll.add(cmbLibrary);


        btnAddBook  = new JButton("Add Book");
        btnAddBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int ok=0;
                if (Objects.equals("Want to read Library", String.valueOf(cmbLibrary.getSelectedItem()))) {
                   System.out.println("Want to read library");
                    if (checkExistanceOfBooks(txtAddBook.getText() )){
                        JOptionPane.showMessageDialog(null, "Book added", "Adding book", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Book doesn't exist", "Adding book", JOptionPane.ERROR_MESSAGE);
                    }

               }else
               {
                   System.out.println("Currently reading library ");
                   AddBookCurrentlyLibrary add2 = new AddBookCurrentlyLibrary();
                   add2.setVisible(true);
               }

            }
        });
        btnAddBook.setBounds(270, 475, 170, 25);
        btnAddBook.setBackground(Color.white);
        scroll.add(btnAddBook);

    }
}


