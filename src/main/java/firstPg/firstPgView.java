package firstPg;
import firstPg.controller.firstPgControllers;
import firstPg.model.AdminView;
import firstPg.model.AuthorView;
import firstPg.model.ReaderView;
import firstPg.model.User;
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
    private firstPgControllers controllerRegistration;
    private JComboBox<String> cmbRole;

    public firstPgView() {

        controller = new firstPgControllers(this);
        controllerRegistration = new firstPgControllers(this);

        setTitle("Reading Tracker Application");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        Color c = Color.pink;
        contentPane.setBackground(c);

        JLabel mainTitle  = new JLabel("Reading Tracker Application");
        mainTitle .setBounds(7, 50, 700, 60);
        mainTitle.setForeground(Color.BLACK);
        mainTitle.setFont(new Font("Lucida Calligraphy", Font.BOLD, 40));
        contentPane.add(mainTitle);

        Color cl = Color.lightGray;
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblUsername.setBounds(90, 150, 120, 25);
        lblUsername.setBackground(cl);
        contentPane.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(180, 150, 350, 25);
        contentPane.add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBackground(Color.BLACK);
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblPassword.setBounds(90, 180, 120, 25);
        lblPassword.setBackground(cl);
        contentPane.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(180, 180, 350, 25);
        contentPane.add(txtPassword);

        JLabel lblRole = new JLabel("Role:");
        lblRole.setBackground(Color.BLACK);
        lblRole.setForeground(Color.BLACK);
        lblRole.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblRole.setBounds(90, 210, 120, 25);
        contentPane.add(lblRole);

        String[] roles = { "Reader", "Author"};
        cmbRole = new JComboBox<>(roles);
        cmbRole.setBounds(380, 210, 150, 25);
        contentPane.add(cmbRole);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(UserService.checkIfAdmin(txtUsername.getText(), new String(txtPassword.getPassword()))) {
                    AdminView adminLog = new AdminView();
                    adminLog.setVisible(true);
                    dispose();
                }
                else {
                    User user = controller.checkAvailability(txtUsername.getText(), new String(txtPassword.getPassword()), String.valueOf(cmbRole.getSelectedItem()));
                    if (user != null) {
                        JOptionPane.showMessageDialog(null, "Successfully!", "Sign in", JOptionPane.INFORMATION_MESSAGE);
                        if (UserService.checkIfReader((String) cmbRole.getSelectedItem()))// reader condition
                        {
                            ReaderView readerLog = new ReaderView(user);
                            readerLog.setVisible(true);
                            dispose();
                        } else
                        {
                            AuthorView authorLog = new AuthorView(user);
                            authorLog.setVisible(true);
                            dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect username or password ", "Login", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnLogin.setBounds(200, 280, 120, 30);
        contentPane.add(btnLogin);

        btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controllerRegistration.checkAvailabilityRegistration(txtUsername.getText(), new String(txtPassword.getPassword()), String.valueOf(cmbRole.getSelectedItem()))) {
                    JOptionPane.showMessageDialog(null, "User successfully added", "Adding user", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "User already added or empty password field", "Adding user", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnRegister.setBounds(340, 280, 120, 30);
        contentPane.add(btnRegister);
    }

    public static void main(String[] args) throws Exception {
        UserService.loadUsersFromFile();
        firstPgView view = new firstPgView();
        view.setVisible(true);
    }
}
