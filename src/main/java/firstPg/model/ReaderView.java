package firstPg.model;

import javax.swing.*;
import java.awt.*;

public class ReaderView extends JFrame {

    private JButton btnSee;
    private JButton btnWantLib;
    private JButton btnCurrentLib;
    private JButton btnProgress;

    public ReaderView()
    {
        setTitle("MyApp: READER PAGE");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 450);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        Color c = Color.pink;
        contentPane.setBackground(c);
        Color cl = Color.lightGray;
        JLabel mainTitle = new JLabel("Welcome, reader! ");
        mainTitle.setBounds(50, 50, 600, 60);
        mainTitle.setForeground(Color.BLACK);
        mainTitle.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        contentPane.add(mainTitle);

        JLabel lblSee = new JLabel("See the list with all the authors:");
        lblSee.setBackground(Color.BLACK);
        lblSee.setForeground(Color.BLACK);
        lblSee.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblSee.setBounds(20, 150, 210, 25);
        lblSee.setBackground(cl);
        contentPane.add(lblSee);

        btnSee = new JButton("SEE THE LIST");
        btnSee.setBounds(270, 150, 350, 25);
        contentPane.add(btnSee);

        JLabel lblWant = new JLabel(" Want to read library:");
        lblWant.setBackground(Color.BLACK);
        lblWant.setForeground(Color.BLACK);
        lblWant.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblWant.setBounds(20, 180, 210, 25);
        lblWant.setBackground(cl);
        contentPane.add(lblWant);

        btnWantLib = new JButton("SEE THE LIBRARY");
        btnWantLib.setBounds(270, 180, 350, 25);
        contentPane.add(btnWantLib);


        JLabel lblCurrent = new JLabel("Currently reading library:");
        lblCurrent.setBackground(Color.BLACK);
        lblCurrent.setForeground(Color.BLACK);
        lblCurrent.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblCurrent.setBounds(20, 210, 210, 25);
        lblCurrent.setBackground(cl);
        contentPane.add(lblCurrent);

        btnCurrentLib = new JButton("SEE THE LIBRARY");
        btnCurrentLib.setBounds(270, 210, 350, 25);
        contentPane.add(btnCurrentLib);

        JLabel lblProgress = new JLabel("Tracking progress page:");
        lblProgress.setBackground(Color.BLACK);
        lblProgress.setForeground(Color.BLACK);
        lblProgress.setFont(new Font("Roboto", Font.PLAIN, 15));
        lblProgress.setBounds(20, 240, 210, 25);
        lblProgress.setBackground(cl);
        contentPane.add(lblProgress);

        btnProgress = new JButton("TRACKING PAGE");
        btnProgress.setBounds(270, 240, 350, 25);
        contentPane.add(btnProgress);

    }

}