package firstPg.services;

import firstPg.exceptions.BookDoesNotExistException;
import firstPg.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ProgressTracking extends JFrame {

    private User user;
    private JTextField bookTitle;
    private JButton seeButton;

    public boolean checkExistanceOfABook (String title)
    {
        try {
            UserService.SearchBook(title);
            return true;
        } catch (BookDoesNotExistException | FileNotFoundException e) {
            return false;
        }
    }

    public ProgressTracking(User user) {
        this.user = user;

        setTitle("Tracking Progress Page");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        Color c = Color.pink;
        contentPane.setBackground(c);
        Color cl = Color.lightGray;

        JLabel mainTitle = new JLabel("The progress for your books");
        mainTitle.setBounds(100, 10, 400, 60);
        mainTitle.setForeground(Color.BLACK);
        mainTitle.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
        contentPane.add(mainTitle);

        JLabel lblTitle = new JLabel("Book Title:");
        lblTitle.setBackground(Color.BLACK);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
        lblTitle.setBounds(30, 90, 120, 35);
        lblTitle.setBackground(cl);
        contentPane.add(lblTitle);

        bookTitle = new JTextField();
        bookTitle.setBounds(140, 90, 320, 25);
        contentPane.add(bookTitle);

        seeButton = new JButton("PROGRESS");
        seeButton.setBounds(180, 140, 170, 25);
        contentPane.add(seeButton);

        seeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkExistanceOfABook(bookTitle.getText())) {
                    new Progress(0);
                    }else { JOptionPane.showMessageDialog(null, "This book is not in your library", "Adding book", JOptionPane.INFORMATION_MESSAGE); }

            }
        });
    }
}
