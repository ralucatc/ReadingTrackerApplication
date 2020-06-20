package firstPg.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User testUser;


    @BeforeEach
    void setUp() {
        testUser = new User();
    }

    @AfterEach
    void tearDown() {
        testUser = null;
    }

    @BeforeAll
    static void beforeAll() {

    }

    @AfterAll
    static void afterAll() {

    }

    @Test
    void testEquals() {
    }

    @Test
    void testToString() {
    }

}