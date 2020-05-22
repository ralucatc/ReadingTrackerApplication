package firstPg.model;

import javax.swing.*;
import java.awt.*;

public class AuthorView extends JFrame {

    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnList;

    public AuthorView()
    {
        setTitle("AUTHOR PAGE");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        Color c = Color.pink;
        contentPane.setBackground(c);
        Color cl = Color.lightGray;
        JLabel mainTitle = new JLabel("Welcome, author! ");
        mainTitle.setBounds(50, 50, 600, 60);
        mainTitle.setForeground(Color.BLACK);
        mainTitle.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        contentPane.add(mainTitle);

        JLabel lblAdd = new JLabel("Add your book:");
        lblAdd.setBackground(Color.BLACK);
        lblAdd.setForeground(Color.BLACK);
        lblAdd.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblAdd.setBounds(20, 150, 210, 25);
        lblAdd.setBackground(cl);
        contentPane.add(lblAdd);

        btnAdd = new JButton("ADD");
        btnAdd.setBounds(270, 150, 350, 25);
        contentPane.add(btnAdd);

        JLabel lblEdit = new JLabel(" Edit my books:");
        lblEdit.setBackground(Color.BLACK);
        lblEdit.setForeground(Color.BLACK);
        lblEdit.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblEdit.setBounds(20, 180, 210, 25);
        lblEdit.setBackground(cl);
        contentPane.add(lblEdit);

        btnEdit = new JButton("EDIT");
        btnEdit.setBounds(270, 180, 350, 25);
        contentPane.add(btnEdit);

        JLabel lblDelete = new JLabel("Delete a book:");
        lblDelete.setBackground(Color.BLACK);
        lblDelete.setForeground(Color.BLACK);
        lblDelete.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblDelete.setBounds(20, 210, 210, 25);
        lblDelete.setBackground(cl);
        contentPane.add(lblDelete);

        btnDelete = new JButton("DELETE");
        btnDelete.setBounds(270, 210, 350, 25);
        contentPane.add(btnDelete);

        JLabel lblList = new JLabel("See all my books:");
        lblList.setBackground(Color.BLACK);
        lblList.setForeground(Color.BLACK);
        lblList.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblList.setBounds(20, 240, 210, 25);
        lblList.setBackground(cl);
        contentPane.add(lblList);

        btnList = new JButton("BOOKS LIST");
        btnList.setBounds(270, 240, 350, 25);
        contentPane.add(btnList);

    }

}
