package firstPg.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import firstPg.exceptions.UsernameAlreadyExistsException;
import firstPg.model.User;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    /*
    @BeforeClass
    public static void setupClass() {
        FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
        FileSystemService.initApplicationHomeDirIfNeeded();
    }


    @Test
    public void testCopyDefaultFileIfNotExists() throws Exception {
        UserService.loadUsersFromFile();
        assertTrue(Files.exists(UserService.USERS_PATH));
    }

    @Test
    public void testLoadUsersFromFile() throws Exception {
        UserService.loadUsersFromFile();
        assertNotNull(UserService.users);
        assertEquals(0, UserService.users.size());
    }

    @Test
    public void testAddOneUser() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addUser("test", "testPass", "432");
        assertNotNull(UserService.users);
        assertEquals(1, UserService.users.size());
    }

    @Test
    public void testAddTwoUsers() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addUser("test1", "testPass1", "123");
        UserService.addUser("test2", "testPass2", "456");
        assertNotNull(UserService.users);
        assertEquals(2, UserService.users.size());
    }

    @Test
    public void testAddUserAlreadyExists() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addUser("test1", "testPass1", "123");
        assertNotNull(UserService.users);
        UserService.checkUserDoesNotAlreadyExist("test1");
    }

    @Test
    public void testAddOneUserIsPersisted() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addUser("test", "testPass", "432");
        List<User> users = new ObjectMapper().readValue(UserService.USERS_PATH.toFile(), new TypeReference<List<User>>() {
        });
        assertNotNull(users);
        assertEquals(1, users.size());
    }

    @Test
    public void testAddTwoUserArePersisted() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addUser("test1", "testPass1", "123");
        UserService.addUser("test2", "testPass2", "432");
        List<User> users = new ObjectMapper().readValue(UserService.USERS_PATH.toFile(), new TypeReference<List<User>>() {
        });
        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    public void testPasswordEncoding() {
        assertNotEquals("testPass1", UserService.encodePassword("username1", "testPass1"));
    }

     */
}