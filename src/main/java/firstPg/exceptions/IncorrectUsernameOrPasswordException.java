package firstPg.exceptions;

public class IncorrectUsernameOrPasswordException extends Exception {
    private String username;

    public IncorrectUsernameOrPasswordException(String username) {
        super(String.format("An account with this username %s and password doesn't exist!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
