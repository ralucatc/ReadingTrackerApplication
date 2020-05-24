package firstPg.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import firstPg.exceptions.BookDoesNotExistException;
import firstPg.model.Books;
import org.apache.commons.io.FileUtils;

import firstPg.exceptions.IncorrectUsernameOrPasswordException;
import firstPg.exceptions.UsernameAlreadyExistsException;
import firstPg.exceptions.CouldNotWriteUsersException;

import firstPg.model.User;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;


public class UserService {

    private static List<User> users;
    private static final Path USERS_PATH = FileSystemService.getPathToFile("config", "users.json");

    public static void loadUsersFromFile() throws IOException {

        if (!Files.exists(USERS_PATH)) {
            FileUtils.copyURLToFile(firstPg.services.UserService.class.getClassLoader().getResource("users.json"), USERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        users = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<User>>() {
        });
    }

    public static int getUsersCount(){
        return users.size();
    }

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        users.add(new User(username, encodePassword(username, password), role, getUsersCount()));
        persistUsers();
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : users) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    public static User checkUser(String username, String password, String role) throws IncorrectUsernameOrPasswordException {
        int ok=0;
        User u = null;
        for (User user : users) {
            if (Objects.equals(username, user.getUsername()) && Objects.equals(role, user.getRole()))
            {
                ok=1;
                u = user;
            }
        }
        if (ok==0)
            throw new IncorrectUsernameOrPasswordException(username);

        return u;
    }

    public static void SearchBooks (String title) throws BookDoesNotExistException, FileNotFoundException {
        int ok = 0;
        File file = new File("src/main/resources/BooksLibrary");
        FileReader reader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(reader);
        String readLine = null;
        try {
            while ((readLine = bufReader.readLine()) != null) {
                String[] splitData = readLine.split(",");
                // System.out.println(splitData[0]);
                String t = splitData[0];
                if (title.equals(t)) {
                    ok = 1;
                }
            }
            if (ok == 0){
                throw new BookDoesNotExistException(title);
            }
        }catch(IOException ex) {}

    }

    public static void SearchBook (String title) throws BookDoesNotExistException, FileNotFoundException {
        int ok = 0;
        File file = new File("src/main/resources/CurrentlyReadingLibrary");
        FileReader reader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(reader);
        String readLine = null;
        try {
            while ((readLine = bufReader.readLine()) != null) {
                String[] splitData = readLine.split(",");
                String t = splitData[0];
                if (title.equals(t)) {
                    ok = 1;
                }
            }
            if (ok == 0){

                throw new BookDoesNotExistException(title);
            }
        }catch(IOException ex) {}
    }

    private static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), users);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("users.json"), users);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    public static boolean checkIfAdmin (String username, String password){
        if(username.equals("admin") && password.equals("admin")){
            return true;
        }
        return false;
    }

    public static boolean checkIfReader (String role){
        if(role.equals("Reader")){
            return true;
        }
        return false;
    }

    public static boolean checkIfAuthor (String role){
        if(role.equals("Author")){
            return true;
        }
        return false;
    }

}


