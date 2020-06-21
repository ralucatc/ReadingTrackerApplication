package firstPg.services;

import firstPg.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ReaderReviews extends JFrame {
    private User user;
    private JTextField bookReview;
    private String bookTitle, Title, Review;
    private JButton btnAddReview;
    static String summery;

    public void addBooksInTxtFileReviews(String title, String review) {
        Title = ("");
        Review = ("");

        Title=title;
        Review=review;

        summery = ( Title + ",") + Review ;

        String Data = summery;

        try {
            BufferedWriter reader1 = new BufferedWriter(new FileWriter(new File("src/main/resources/Reviews"), true));
            reader1.write(Data);
            reader1.newLine();
            reader1.close();
        } catch (IOException E) {
            System.out.println("Error is " + E);
        }
    }

    public ReaderReviews(String title) {

        this.user = user;
        this.bookTitle = title;

        setLayout(new BorderLayout());
        setTitle("Review Page");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 350);
        setLocationRelativeTo(null);
        setVisible(true);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        Color c = Color.pink;
        contentPane.setBackground(c);
        Color cl = Color.lightGray;

        JLabel mainTitle = new JLabel("Leave a review");
        mainTitle.setBounds(180, 50, 600, 30);
        mainTitle.setForeground(Color.BLACK);
        mainTitle.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));
        contentPane.add(mainTitle);

        JLabel lblTitle = new JLabel("Book title:");
        lblTitle.setBackground(Color.BLACK);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Lucida Calligraphy", Font.ITALIC, 20));
        lblTitle.setBounds(50, 120, 200, 30);
        lblTitle.setBackground(cl);
        contentPane.add(lblTitle);

        JLabel lblGivenTitle = new JLabel(bookTitle);
        lblGivenTitle.setBackground(Color.BLACK);
        lblGivenTitle.setForeground(Color.BLACK);
        lblGivenTitle.setFont(new Font("Lucida Calligraphy", Font.ITALIC, 20));
        lblGivenTitle.setBounds(200, 120, 600, 30);
        lblGivenTitle.setBackground(cl);
        contentPane.add(lblGivenTitle);

        JLabel lblReview = new JLabel("Review:");
        lblReview.setBackground(Color.BLACK);
        lblReview.setForeground(Color.BLACK);
        lblReview.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        lblReview.setBounds(50, 180, 200, 30);
        lblReview.setBackground(cl);
        contentPane.add(lblReview);

        bookReview = new JTextField();
        bookReview.setBounds(200, 180, 400, 25);
        contentPane.add(bookReview);

        btnAddReview  = new JButton("Add Review");
        btnAddReview.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((bookReview.getText()).equals("")) {
                    JOptionPane.showMessageDialog(null, "Sorry, your review box is empty!", "Adding review", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    addBooksInTxtFileReviews(bookTitle, bookReview.getText());
                    JOptionPane.showMessageDialog(null, "Thank you for your review!", "Adding review", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });
        btnAddReview.setBounds(200,250, 160, 25);
        btnAddReview.setBackground(Color.white);
        contentPane.add(btnAddReview);
    }
}
