package easykanbanapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Login {
    private List<User> users = new ArrayList<>();

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        users.add(new User(username, password, firstName, lastName));
        return "User registered successfully.";
    }

    public boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            User user = users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
            if (user != null) {
                return "Welcome " + user.getFirstName() + " " + user.getLastName() + ", it is great to see you again.";
            }
        }
        return "Username or password incorrect, please try again";
    }
}
