package firstPg.services;

import firstPg.model.Books;
import firstPg.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteBook extends JFrame {

    private JTextField bookTitle;
    private JButton btnDelete;
    private User user;

    public DeleteBook(User user) {
        this.user = user;
        setTitle("Delete a book");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        Color c = Color.pink;
        contentPane.setBackground(c);
        Color cl = Color.lightGray;
        JLabel mainTitle = new JLabel("Delete a book");
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

        btnDelete = new JButton("DELETE");
        btnDelete.setBounds(270, 180, 100, 25);
        contentPane.add(btnDelete);

        btnDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int a = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Select an Option...",
                        JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                if (a == 0){
                    File file = new File("src/main/resources/BooksLibrary");
                    try {
                        FileReader reader = new FileReader(file);
                        BufferedReader bufReader = new BufferedReader(reader);
                        String readLine;
                        boolean found = false;
                        while ((readLine = bufReader.readLine()) != null) {
                            String[] splitData = readLine.split(",");
                            String userID = splitData[4];
                            if (userID.trim().equals(String.valueOf(user.getID()))) {
                                if (splitData[0].trim().equals(bookTitle.getText())) {
                                    found = true;
                                }
                            }
                        }
                        if (!found) {
                            JOptionPane.showMessageDialog(null, "Couldn't find the book. Try again.");
                        } else {
                            JOptionPane.showMessageDialog(null, "The book is now deleted.");
                        }
                    } catch(Exception e){
                        e.printStackTrace();
                        }
                    }
                }
        });
    }
}
