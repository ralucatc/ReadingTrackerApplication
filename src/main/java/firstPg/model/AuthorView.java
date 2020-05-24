package firstPg.model;

import firstPg.firstPgView;
import firstPg.services.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class AuthorView extends JFrame {

    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnList;
    private User user;

    public AuthorView(User user)
    {
        this.user = user;
        setTitle("AUTHOR PAGE");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                firstPgView view = new firstPgView();
                view.setVisible(true);
                dispose();
            }
        });

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

        btnAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddBook add = new AddBook(user);
                add.setVisible(true);
            }
        });

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

        btnEdit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EditBook edit = new EditBook();
                edit.setVisible(true);
            }
        });

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

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteBook delete = new DeleteBook(user);
                delete.setVisible(true);
            }
        });

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

        btnList.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                File file = new File("src/main/resources/BooksLibrary");
                try {
                    FileReader reader = new FileReader(file);
                    BufferedReader bufReader = new BufferedReader(reader);

                    String readLine;
                    ArrayList<Books> booksList = new ArrayList<Books>();
                    while ((readLine = bufReader.readLine()) != null) {
                        String[] splitData = readLine.trim().split(",");
                        String userID = splitData[4];
                        if(userID.trim().equals(String.valueOf(user.getID()))){
                            Books book = new Books();
                            book.setTitle(splitData[0]);
                            book.setAuthor(splitData[1]);
                            book.setPublicationYear(splitData[2]);
                            book.setDescription(splitData[3]);
                            booksList.add(book);
                        }
                    }
                    new AuthorBooks(booksList);
                } catch (Exception e){
                    e.printStackTrace();
                }
               // setVisible(false);
            }
        });



    }

}
