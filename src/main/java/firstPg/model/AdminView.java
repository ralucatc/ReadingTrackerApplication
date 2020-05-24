package firstPg.model;
import firstPg.firstPgView;
import firstPg.services.AddBook;
import firstPg.services.DeleteAdmin;

import firstPg.services.EditBook;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminView extends JFrame {
    private JButton btnAdd;
    private JButton btnEditBook;
    private JButton btnDeleteBook;
    private JButton  btnLogout;

    public AdminView()
    {
        User user = new User("admin", "admin", "", 1000);
        setTitle("ADMIN PAGE");
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
        JLabel mainTitle = new JLabel("Welcome, admin! ");
        mainTitle.setBounds(50, 50, 600, 60);
        mainTitle.setForeground(Color.BLACK);
        mainTitle.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 46));
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

        btnAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddBook add = new AddBook(user);
                add.setVisible(true);
            }
        });


        JLabel lblDelete = new JLabel("Delete a book:");
        lblDelete.setBackground(Color.BLACK);
        lblDelete.setForeground(Color.BLACK);
        lblDelete.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblDelete.setBounds(20, 210, 210, 25);
        lblDelete.setBackground(cl);
        contentPane.add(lblDelete);

        btnDeleteBook = new JButton("DELETE");
        btnDeleteBook.setBounds(180, 210, 350, 25);
        contentPane.add(btnDeleteBook);

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(520, 360, 150, 25);; // 700, 450
        contentPane.add(btnLogout);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Are you sure?", "Logout",
                        JOptionPane.YES_NO_CANCEL_OPTION);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    firstPgView view = new firstPgView();
                    view.setVisible(true);
                }else {
                    dispose();
                    ReaderView view = new ReaderView(user);
                    view.setVisible(true);
                }
            }
        });


        btnDeleteBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteAdmin delete = new DeleteAdmin();
                delete.setVisible(true);
            }
        });
    }
}
