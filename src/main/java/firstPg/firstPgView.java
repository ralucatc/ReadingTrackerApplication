package firstPg;

import firstPg.controller.firstPgControllers;
import firstPg.services.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class firstPgView extends JFrame{

    private JButton btnRegister;
    private JButton btnLogin;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private firstPgControllers controller;


    public firstPgView() {
        controller = new firstPgControllers(this);
        //TODO implementare - de facut sa mearga mai bine si corect

        setTitle("MyApp: First Page App");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        Color c = Color.pink;
        contentPane.setBackground(c);

        Color cl = Color.lightGray;
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(10, 150, 120, 25);
        lblUsername.setBackground(cl);
        contentPane.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(80, 150, 250, 25);
        contentPane.add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(10, 180, 120, 25);
        lblPassword.setBackground(cl);
        contentPane.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(80, 180, 250, 25);
        contentPane.add(txtPassword);

        JLabel ForgotCredentials  = new JLabel("Forgot Credentials?");
        ForgotCredentials .setBounds(220, 205, 120, 25);
        ForgotCredentials.setBackground(cl);
        contentPane.add(ForgotCredentials);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.checkAvailability(txtUsername.getText(), new String(txtPassword.getPassword()) )) {
                    JOptionPane.showMessageDialog(null, "Successfully!", "Sign in", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password ", "Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLogin.setBounds(180, 245, 120, 30);
        contentPane.add(btnLogin);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(390, 245, 120, 30);
        //TODO register login to do smth
        contentPane.add(btnRegister);
    }

    public static void main(String[] args) throws Exception {
        UserService.loadUsersFromFile();

        firstPgView view = new firstPgView();
        view.setVisible(true);
    }

}
