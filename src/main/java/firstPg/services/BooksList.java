package firstPg.services;
import firstPg.exceptions.BookDoesNotExistException;
import firstPg.model.Books;
import firstPg.model.ReaderView;
import firstPg.model.User;
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
    private User user;

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

        summery = ( Title + ",") + ( Author + ",") + ( Year + ",") + ( Summary + ",") + user.getID();

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
        } catch(IOException ex) {
            System.out.println("Error is " + ex);
        }

        summery = ( Title + ",") + ( Author + ",") + ( Year + ",") + ( Summary + ",") + user.getID();

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


    public BooksList(User user) throws FileNotFoundException {

        this.user = user;
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("All the books added in the application");
        setResizable(false);
        setSize(500, 600);
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

        panel1.setBounds(0,0,500, 300);
        panel1.setBackground(c);
        contentPane.add(panel1);
        // content for panel1- the table part

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
        table.setBackground(pink);
        table.getTableHeader().setBackground(c);
        JScrollPane scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(pink);
        panel1.add(scroll);

        table.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(e -> {
            String selectedData = null;

            int[] selectedRow = table.getSelectedRows();
            int[] selectedColumns = table.getSelectedColumns();

            if (selectedColumns[0] == 0) {
                for (int i = 0; i < selectedRow.length; i++) {
                        selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[0]);
                   }
                int a = JOptionPane.showConfirmDialog(null, "Do you want to leave a review?", "Select an Option...",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (a == 0) {
                    new ReaderReviews(selectedData);
                }
            }
        });

        JLabel lblWriteBook = new JLabel("Write the Book Title");
        lblWriteBook.setBounds(30, 360, 200, 25);
        lblWriteBook.setForeground(Color.BLACK);
        lblWriteBook.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblWriteBook.setBackground(cl);
        contentPane.add(lblWriteBook);

        txtAddBook = new JTextField();
        txtAddBook.setBounds(20, 390, 200, 25);
        txtAddBook.setBackground(Color.white);
        contentPane.add(txtAddBook);

        JLabel lblRoleLib = new JLabel("Choose Personal Library:");
        lblRoleLib.setBackground(Color.BLACK);
        lblRoleLib.setForeground(Color.BLACK);
        lblRoleLib.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblRoleLib.setBounds(280, 360, 200, 25);
        contentPane.add(lblRoleLib);

        String[] library = { "Want to read Library", "Currently reading Library"};
        cmbLibrary = new JComboBox<>(library);
        cmbLibrary.setBounds(270, 390, 200, 25);

        contentPane.add(cmbLibrary);

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
        btnAddBook.setBounds(170,450, 160, 25);
        btnAddBook.setBackground(Color.white);
        contentPane.add(btnAddBook);
    }
}


