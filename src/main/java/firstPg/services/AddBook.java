package firstPg.services;

import firstPg.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AddBook extends JFrame {
    private JTextField bookTitle;
    private JTextField authorName;
    private JTextField year;
    private JTextField summary;
    private JButton addButton;
    private String Title, Author, Year, Summary;
    static String summery;
    private User user;

    public void addBook (String Data){
        try {
            BufferedWriter reader1 = new BufferedWriter(new FileWriter(new File("src/main/resources/BooksLibrary"), true));
            reader1.write(Data);
            reader1.newLine();
            reader1.close();
            JOptionPane.showMessageDialog(null, "Book added!", "Adding book", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (IOException E) {
            System.out.println("Error is " + E);
        }
    }

    public AddBook(User user) {
        this.user = user;
        setTitle("Add a book");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        Color c = Color.pink;
        contentPane.setBackground(c);
        Color cl = Color.lightGray;
        JLabel mainTitle = new JLabel("Add a new book");
        mainTitle.setBounds(50, 10, 600, 60);
        mainTitle.setForeground(Color.BLACK);
        mainTitle.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
        contentPane.add(mainTitle);

        JLabel lblTitle = new JLabel("Book Title:");
        lblTitle.setBackground(Color.BLACK);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
        lblTitle.setBounds(20, 90, 120, 25);
        lblTitle.setBackground(cl);
        contentPane.add(lblTitle);

        bookTitle = new JTextField();
        bookTitle.setBounds(180, 90, 200, 25);
        contentPane.add(bookTitle);

        JLabel lblAuthor = new JLabel("Author Name:");
        lblAuthor.setBackground(Color.BLACK);
        lblAuthor.setForeground(Color.BLACK);
        lblAuthor.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
        lblAuthor.setBounds(20, 120, 120, 25);
        lblAuthor.setBackground(cl);
        contentPane.add(lblAuthor);

        authorName = new JTextField();
        authorName.setBounds(180, 120, 200, 25);
        contentPane.add(authorName);

        JLabel lblYear = new JLabel("Year of publication:");
        lblYear.setBackground(Color.BLACK);
        lblYear.setForeground(Color.BLACK);
        lblYear.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
        lblYear.setBounds(20, 150, 200, 25);
        lblYear.setBackground(cl);
        contentPane.add(lblYear);

        year = new JTextField();
        year.setBounds(180, 150, 200, 25);
        contentPane.add(year);

        JLabel lblSummary = new JLabel("Book Summary:");
        lblSummary.setBackground(Color.BLACK);
        lblSummary.setForeground(Color.BLACK);
        lblSummary.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
        lblSummary.setBounds(20, 180, 200, 25);
        lblSummary.setBackground(cl);
        contentPane.add(lblSummary);

        summary = new JTextField();
        summary.setBounds(180, 180, 200, 25);
        contentPane.add(summary);

        addButton = new JButton("ADD");
        addButton.setBounds(180, 220, 150, 25);
        contentPane.add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Title = ("");
                Author = ("");
                Year = ("");
                Summary = ("");

                Title = bookTitle.getText().trim();
                Author = authorName.getText().trim();
                Year = year.getText().trim();
                Summary = summary.getText().trim();

                summery = ( Title + ",") + ( Author + ",") + ( Year + ",") + ( Summary + ",") + ( user.getID()) ;

                String myData = AddBook.summery;
                addBook(myData);
            }
        });


    }

}
