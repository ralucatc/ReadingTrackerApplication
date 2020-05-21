package firstPg.model;
import firstPg.controller.firstPgControllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {
    private JButton btnAdd;
    private JButton btnEditBook;
    private JButton btnDeleteBook;

    public AdminView()
    {
        setTitle("MyApp: ADMIN PAGE");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 450);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        Color c = Color.pink;
        contentPane.setBackground(c);
        Color cl = Color.lightGray;
        JLabel mainTitle = new JLabel("Welcome, admin! ");
        mainTitle.setBounds(50, 50, 600, 60);
        mainTitle.setForeground(Color.BLACK);
        mainTitle.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        contentPane.add(mainTitle);

        JLabel lblAdd = new JLabel("Add a new book:");
        lblAdd.setBackground(Color.BLACK);
        lblAdd.setForeground(Color.BLACK);
        lblAdd.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblAdd.setBounds(20, 150, 120, 25);
        lblAdd.setBackground(cl);
        contentPane.add(lblAdd);

        btnAdd = new JButton("ADD");
        btnAdd.setBounds(180, 150, 350, 25);
        contentPane.add(btnAdd);

        JLabel lblEdit = new JLabel("Edit a book:");
        lblEdit.setBackground(Color.BLACK);
        lblEdit.setForeground(Color.BLACK);
        lblEdit.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblEdit.setBounds(20, 180, 120, 25);
        lblEdit.setBackground(cl);
        contentPane.add(lblEdit);

        btnEditBook = new JButton("EDIT");
        btnEditBook.setBounds(180, 180, 350, 25);
        contentPane.add(btnEditBook);

        JLabel lblDelete = new JLabel("Delete a book:");
        lblDelete.setBackground(Color.BLACK);
        lblDelete.setForeground(Color.BLACK);
        lblDelete.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblDelete.setBounds(20, 210, 120, 25);
        lblDelete.setBackground(cl);
        contentPane.add(lblDelete);

        btnDeleteBook = new JButton("DELETE");
        btnDeleteBook.setBounds(180, 210, 350, 25);
        contentPane.add(btnDeleteBook);
    }
}
