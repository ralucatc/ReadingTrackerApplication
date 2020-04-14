package registration.controllers;

import registration.RegistrationView;
import registration.exceptions.UsernameAlreadyExistsException;
import registration.services.UserService;

public class RegistrationController {
    private RegistrationView view;

    public RegistrationController(RegistrationView view) {
        this.view = view;
    }

    public boolean checkAvailability(String username, String password, String role) {
        try {
            UserService.addUser(username, password, role);
            return true;
        } catch (UsernameAlreadyExistsException e) {
            return false;
        }
    }
}
