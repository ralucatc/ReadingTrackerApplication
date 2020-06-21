package firstPg.model;

import java.awt.print.Book;
import java.util.ArrayList;

public class Admin extends User{
    ArrayList<Book> mainLibrary = new ArrayList<Book>();

    public Admin() {
        String username = "admin";
        String password = "admin";
    }

    public void addBooks(Book book){
        mainLibrary.add(book);
    }
}
