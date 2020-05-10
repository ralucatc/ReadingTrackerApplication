package firstPg.controllers;

import firstPg.firstPageView;
import firstPg.exceptions.IncorrectUsernameOrPasswordException;
import firstPg.services.UserService;

public class firstPageController {
    private firstPageView view;

    public firstPageController(firstPageView view) {
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
