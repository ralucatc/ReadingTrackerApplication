package firstPg.services;
import firstPg.changePassword;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class EditBook extends JFrame{
    private JTextField bookTitle;

    public EditBook() {
        setTitle("Edit a book");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        Color c = Color.pink;
        contentPane.setBackground(c);
        Color cl = Color.lightGray;
        JLabel mainTitle = new JLabel("Edit a book");
        mainTitle.setBounds(50, 10, 600, 60);
        mainTitle.setForeground(Color.BLACK);
        mainTitle.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
        contentPane.add(mainTitle);

        JLabel lblTitle = new JLabel("Please enter the Book Title:");
        lblTitle.setBackground(Color.BLACK);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
        lblTitle.setBounds(20, 100, 300, 25);
        lblTitle.setBackground(cl);
        contentPane.add(lblTitle);

        bookTitle = new JTextField();
        bookTitle.setBounds(250, 100, 200, 25);
        contentPane.add(bookTitle);
    }
}
