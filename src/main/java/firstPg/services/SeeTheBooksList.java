package firstPg.services;

import firstPg.model.Books;
import firstPg.model.ReaderView;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SeeTheBooksList extends JFrame {

   public SeeTheBooksList(){
      /* setTitle("All the books added in the application");
       setResizable(false);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setSize(500, 600);
       setLocationRelativeTo(null);

       Container contentPane = this.getContentPane();
       contentPane.setLayout(null);
       Color c = Color.pink;
       contentPane.setBackground(c);
       setVisible(true);
    */

       try {

           JFrame frame = new JFrame();
           frame.setLayout(new BorderLayout());

           frame.addWindowListener(new WindowAdapter() {
               @Override
               public void windowClosing(WindowEvent e) {
                   ReaderView view = new ReaderView();
                   view.setVisible(true);
                   dispose();
               }
           });

           JTable table = new JTable();

           String readLine = null;

           BooksListTableModel tableModel = new BooksListTableModel();
           File file = new File("src/main/resources/BooksLibrary");

           FileReader reader = new FileReader(file);
           BufferedReader bufReader = new BufferedReader(reader);

           List<Books> booksList = new ArrayList<>();
           while((readLine = bufReader.readLine()) != null) {
               String[] splitData = readLine.split(",");
               Books book = new Books();
               book.setTitle(splitData[0]);
               book.setAuthor(splitData[1]);
               booksList.add(book);
           }

           tableModel.setList(booksList);
           table.setModel(tableModel);

           frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           frame.add(new JScrollPane(table));
           frame.setTitle("All the books added in the application");
           frame.setResizable(false);
           frame.setSize(500, 600);
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);

       } catch(IOException ex) {}
    }
}


