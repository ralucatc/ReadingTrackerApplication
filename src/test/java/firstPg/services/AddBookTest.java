package firstPg.services;

import firstPg.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddBookTest {

    AddBook test;
    private User user;
    @BeforeEach
    void setUp() {
        test = new AddBook(user);
    }

    @AfterEach
    void tearDown() {
        test = null;
    }

    @Test
    void addBook() {
       // test.addBook("myData");
        //System.out.println("myData");
    }
}