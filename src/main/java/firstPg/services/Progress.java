package firstPg.services;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Progress extends JFrame {

    private JProgressBar bar;
    private JButton button;
    private JButton buttonUpdate;

    public Progress (int valueOfPorgress){

        setSize(250,200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Progress Page");
        setResizable(false);
        setLocationRelativeTo(null);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        bar = new JProgressBar();
        bar.setStringPainted(true);
        bar.setMaximum(100);
        bar.setValue(valueOfPorgress);
        bar.setBounds(20, 70 , 200, 25);

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
        contentPane.add(bar);

        buttonUpdate = new JButton("Update Progress");
        buttonUpdate.setBounds(50, 110, 150, 25);

        contentPane.add(buttonUpdate);

        setVisible(true);
    }
}
