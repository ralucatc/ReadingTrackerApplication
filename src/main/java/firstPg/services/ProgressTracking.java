package firstPg.services;

import firstPg.exceptions.BookDoesNotExistException;
import firstPg.model.ReaderView;
import firstPg.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class ProgressTracking extends JFrame {

    private User user;
    private JTextField bookTitle;
    private JButton seeButton;
    private int ok;
    private int prog;

    public static void SearchBookCurrentLib (String title, int id) throws BookDoesNotExistException, FileNotFoundException {
        int ok = 0;
        File file = new File("src/main/resources/CurrentlyReadingLibrary");
        FileReader reader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(reader);
        String readLine = null;
        try {
            while ((readLine = bufReader.readLine()) != null) {
                String[] splitData = readLine.split(",");
                String t = splitData[0];
                String userID = splitData[4];
                if (title.equals(t) && userID.trim().equals(String.valueOf(id))) {
                    ok = 1;
                }
            }
            if (ok == 0){
                throw new BookDoesNotExistException(title);
            }
        }catch(IOException ex) {}
    }


    public boolean checkExistanceOfABook (String title, int id)
    {
        try {
            SearchBookCurrentLib(title, id);
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

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ReaderView view = new ReaderView(user);
                view.setVisible(true);
                dispose();
            }
        });

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
                if (checkExistanceOfABook(bookTitle.getText(), user.getID())) {
                    ok=0;
                    String readLine = null;
                    File file = new File("src/main/resources/ProgressTrackingTxt");
                    FileReader reader = null;
                    try {
                                reader = new FileReader(file);
                    } catch (FileNotFoundException fileNotFoundException) {
                                fileNotFoundException.printStackTrace();
                    }
                    BufferedReader bufReader = new BufferedReader(reader);
                    try {
                        while((readLine = bufReader.readLine()) != null) {
                            String[] splitData = readLine.split(",");
                            String title = splitData[1];
                            int id=Integer.parseInt(splitData[2]);
                            if (title.equals(bookTitle.getText()) && user.getID()==id) {
                                String progress = splitData[0];
                                prog = Integer.parseInt(progress);
                                if (prog>0)
                                    ok=1;
                            }
                        }
                    } catch(IOException ex) {}
                    if(ok==0)
                        new Progress(0, user, bookTitle.getText());
                    else
                        new Progress(prog, user, bookTitle.getText());
                }else {
                    JOptionPane.showMessageDialog(null, "This book is not in your library", "Adding book", JOptionPane.INFORMATION_MESSAGE);
                    //dispose();
                }
            }
        });
    }
}
