package firstPg.services;

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
    private String Title, Author, Year, Summary;
    static String summery;
    private String[] splitData;

    public boolean checkExistanceOfBooks (String title)
    {
        try {
        UserService.SearchBooks(title);
            return true;
        } catch (BookDoesNotExistException | FileNotFoundException e) {
            return false;
        }
    }

    public void addBooksInTxtFileWantLibrary(String title) throws FileNotFoundException {
        Title = ("");
        Author = ("");
        Year = ("");
        Summary = ("");

        File file = new File("src/main/resources/BooksLibrary");
        FileReader reader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(reader);
        String readLine = null;
        try {
            while((readLine = bufReader.readLine()) != null) {
                splitData = readLine.split(",");
                if (title.equals(splitData[0])){
                    Title=splitData[0];
                    Author=splitData[1];
                    Year=splitData[2];
                    Summary=splitData[3];
                }
            }
        } catch(IOException ex) {}

        summery = ( Title + " , ") + ( Author + " , ") + ( Year + " , ") + ( Summary + " , ") ;

        String Data = summery;

        try {
            BufferedWriter reader1 = new BufferedWriter(new FileWriter(new File("src/main/resources/WantToReadLibrary"), true));
            reader1.write(Data);
            reader1.newLine();
            reader1.close();
        } catch (IOException E) {
            System.out.println("Error is " + E);
        }
    }

    public void addBooksInTxtFileCurrentlyLibrary(String title) throws FileNotFoundException {
        Title = ("");
        Author = ("");
        Year = ("");
        Summary = ("");

        File file = new File("src/main/resources/BooksLibrary");
        FileReader reader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(reader);
        String readLine = null;
        try {
            while((readLine = bufReader.readLine()) != null) {
                splitData = readLine.split(",");
                if (title.equals(splitData[0])){
                    Title=splitData[0];
                    Author=splitData[1];
                    Year=splitData[2];
                    Summary=splitData[3];
                }
            }
        } catch(IOException ex) {}

        summery = ( Title + " , ") + ( Author + " , ") + ( Year + " , ") + ( Summary + " , ") ;

        String Data = summery;

        try {
            BufferedWriter reader1 = new BufferedWriter(new FileWriter(new File("src/main/resources/CurrentlyReadingLibrary"), true));
            reader1.write(Data);
            reader1.newLine();
            reader1.close();
        } catch (IOException E) {
            System.out.println("Error is " + E);
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

        // TO DO - resolve the problem in the title, with that space
        // TO DO - add anew panel or smth, the information is not visible

        JLabel lblWriteBook = new JLabel("Write the name of the book you want to add in your personal library");
        JLabel lblWriteBookPROBLEM = new JLabel("ADD A SPACE AFTER THE NAME OF THE BOOK!");

        lblWriteBook.setBounds(10, 390, 500, 25);
        lblWriteBookPROBLEM.setBounds(10, 415, 500, 25);

       scroll.add(lblWriteBook);
       scroll.add(lblWriteBookPROBLEM);

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
                if (Objects.equals("Want to read Library", String.valueOf(cmbLibrary.getSelectedItem()))) {
                        if (checkExistanceOfBooks(txtAddBook.getText())) {
                                try {
                                    addBooksInTxtFileWantLibrary(txtAddBook.getText());
                                } catch (FileNotFoundException fileNotFoundException) {
                                    fileNotFoundException.printStackTrace();
                                }
                                JOptionPane.showMessageDialog(null, "Book added", "Adding book", JOptionPane.INFORMATION_MESSAGE);
                            }else { JOptionPane.showMessageDialog(null, "Book doesn't exist in the application", "Adding book", JOptionPane.INFORMATION_MESSAGE); }

                    } else {
                    if (checkExistanceOfBooks(txtAddBook.getText())) {
                        try {
                            addBooksInTxtFileCurrentlyLibrary( txtAddBook.getText());
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "Book added", "Adding book", JOptionPane.INFORMATION_MESSAGE);
                    }else { JOptionPane.showMessageDialog(null, "Book doesn't exist in the application", "Adding book", JOptionPane.INFORMATION_MESSAGE); }
                }
            }

        });
        btnAddBook.setBounds(270, 475, 170, 25);
        btnAddBook.setBackground(Color.white);
        scroll.add(btnAddBook);

    }
}


