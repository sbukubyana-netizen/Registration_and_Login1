package com.mycompany.registration_and_login1;

public class Login { // checking if the user meets certain conditions before gran



    public boolean checkUserName(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W_]).{8,}$");
    }

    public boolean checkCellPhoneNumber(String cellnumber) {
        return cellnumber.matches("^\\+[0-9]{1,3}[0-9]{1,15}$");
    }

    public String registerUser(String username, String password) {
        String message = "";

        if (!(username.length() <= 5 && username.contains("_"))) {
            message += "The username is incorrectly formatted. ";
        }

        if (!(password.length() >= 8 &&
              password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W_]).{8,}$"))) {
            message += "The password does not meet the complexity requirements.";
        }

        if (message.isEmpty()) {
            message = "The above conditions have been met, and the user has been registered successfully";
        }

        return message;
    }

    public boolean loginUser(String login_username, String username,
                             String login_password, String password) {
        return login_username.equals(username) && login_password.equals(password);
    }

    public String returnLoginStatus(String login_username, String username,
                                   String login_password, String password) {

        if (!login_username.equals(username) || !login_password.equals(password)) {
            return "A failed login";
        } else {
            return "A successful login";
        }
    }
}