package firstPg.services;
import firstPg.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgressTrackingTest {

    ProgressTracking test ;
    private User userTest;
    @BeforeEach
    void setUp() {
        test = new ProgressTracking(userTest);
    }

    @AfterEach
    void tearDown() {
        test = null;
    }

    @Test
    void checkExistanceOfABook() {
        assert !test.checkExistanceOfABook("Harap Alb");
    }

}