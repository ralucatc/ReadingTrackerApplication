package firstPg.controller;

import firstPg.firstPgView;
import firstPg.exceptions.IncorrectUsernameOrPasswordException;
import firstPg.services.UserService;

public class firstPgControllers {
    private firstPgView view;

    public firstPgControllers(firstPgView view) {
        this.view = view;
    }

    public boolean checkAvailability(String username, String password) {
        try {
            UserService.checkUser(username, password);
            return true;
        } catch (IncorrectUsernameOrPasswordException e) {
            return false;
        }
    }
}
