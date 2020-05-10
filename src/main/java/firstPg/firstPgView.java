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
    private JComboBox<String> cmbRole;
    private firstPgControllers controllerRegistration;

    public firstPgView() {
        controller = new firstPgControllers(this);
        controllerRegistration = new firstPgControllers(this);
        //TODO implementare - de facut sa mearga mai bine si corect

        setTitle("MyApp: First Page App");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 500);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        Color c = Color.pink;
        contentPane.setBackground(c);

        JLabel mainTitle  = new JLabel("Reading Tracker Application ");
        mainTitle .setBounds(300, 50, 400, 40);
        contentPane.add(mainTitle);

        Color cl = Color.lightGray;
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(110, 150, 120, 25);
        lblUsername.setBackground(cl);
        contentPane.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(180, 150, 350, 25);
        contentPane.add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(110, 180, 120, 25);
        lblPassword.setBackground(cl);
        contentPane.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(180, 180, 350, 25);
        contentPane.add(txtPassword);

        JLabel lblRole = new JLabel("Role:");
        lblRole.setBounds(110, 210, 120, 25);
        contentPane.add(lblRole);

        String[] roles = { "Reader", "Author"};
        cmbRole = new JComboBox<>(roles);
        cmbRole.setBounds(380, 210, 150, 25);
        contentPane.add(cmbRole);

        JLabel ForgotCredentials  = new JLabel("Forgot Credentials?");
        ForgotCredentials .setBounds(415, 240, 120, 25);
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

        btnLogin.setBounds(200, 270, 120, 30);
        contentPane.add(btnLogin);

        btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controllerRegistration.checkAvailabilityRegistration(txtUsername.getText(), new String(txtPassword.getPassword()), String.valueOf(cmbRole.getSelectedItem()))) {
                    JOptionPane.showMessageDialog(null, "User successfully added", "Adding user", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "User already added", "Adding user", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnRegister.setBounds(340, 270, 120, 30);
        contentPane.add(btnRegister);
    }

    public static void main(String[] args) throws Exception {
        UserService.loadUsersFromFile();
        firstPgView view = new firstPgView();
        view.setVisible(true);
    }

}
