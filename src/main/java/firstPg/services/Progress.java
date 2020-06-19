package firstPg.services;

import firstPg.model.User;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Progress extends JFrame {

    private JProgressBar bar;
    private JButton button;
    private JButton buttonUpdate;
    static String summery;
    private String[] splitData;

    // citesc din fisier
    //int ProgressTxtReading

    //scriu in fisier
    public void addDetailsInTxtProgressFile (String title, int progress, int id) throws FileNotFoundException {

        summery = (progress + ",") + ( title + ",") + id;
        String Data = summery;
        try {
            BufferedWriter reader1 = new BufferedWriter(new FileWriter(new File("src/main/resources/ProgressTrackingTxt"), true));
            reader1.write(Data);
            reader1.newLine();
            reader1.close();
        } catch (IOException E) {
            System.out.println("Error is " + E);
        }
    }


    public Progress (int valueOfProgress, User user, String title){

        setSize(250,200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Progress Page");
        setResizable(false);
        setLocationRelativeTo(null);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        button = new JButton("Increase");
        button.setBounds(70, 30, 100, 25);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bar.setValue(bar.getValue()+1);
            }
        });
        button.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                if (bar.getValue()>90)
                    bar.setString("Almost complete");
                if (bar.getValue()==100)
                    bar.setString("Complete");
            }
        });
        contentPane.add(button);

        bar = new JProgressBar();
        bar.setStringPainted(true);
        bar.setMaximum(100);
        bar.setValue(valueOfProgress);
        bar.setBounds(20, 70 , 200, 25);

        contentPane.add(bar);

        buttonUpdate = new JButton("Update Progress");
        buttonUpdate.setBounds(50, 110, 150, 25);

        buttonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the progress?", "Update Progress",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (a == 0) {
                    try {
                        addDetailsInTxtProgressFile(  title ,bar.getValue(),user.getID());
                        System.out.println(title);
                        JOptionPane.showMessageDialog(null, "You have updated your progress!", "Thank you!",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }

                }
            }
        });

        contentPane.add(buttonUpdate);

        setVisible(true);
    }
}
