package firstPg.controller;

import firstPg.firstPgView;
import firstPg.exceptions.IncorrectUsernameOrPasswordException;
import firstPg.services.UserService;
import firstPg.exceptions.UsernameAlreadyExistsException;

public class firstPgControllers {
    private firstPgView view;

    public firstPgControllers(firstPgView view) {
        this.view = view;
    }

    public boolean checkAvailability(String username, String password, String role) {
        try {
            UserService.checkUser(username, password, role);
            return true;
        } catch (IncorrectUsernameOrPasswordException e) {
            return false;
        }
    }
    public boolean checkAvailabilityRegistration(String username, String password, String role) {
        try {
            UserService.addUser(username, password, role);
            return true;
        } catch (UsernameAlreadyExistsException e) {
            return false;
        }
    }
}
