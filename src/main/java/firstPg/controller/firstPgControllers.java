package firstPg.controller;

import firstPg.exceptions.EmptyFieldException;
import firstPg.firstPgView;
import firstPg.exceptions.IncorrectUsernameOrPasswordException;
import firstPg.model.User;
import firstPg.services.UserService;
import firstPg.exceptions.UsernameAlreadyExistsException;

public class firstPgControllers {

    private firstPgView view;
    public firstPgControllers(firstPgView view) {
        this.view = view;
    }

    public User checkAvailability(String username, String password, String role) {
        try {
            return UserService.checkUser(username, password, role);
        } catch (IncorrectUsernameOrPasswordException e) {
            return null;
        }
    }
    public boolean checkAvailabilityRegistration(String username, String password, String role) {
        try {
            UserService.addUser(username, password, role);
            return true;
        } catch (EmptyFieldException | UsernameAlreadyExistsException e) {
            return false;
        }
    }
}
