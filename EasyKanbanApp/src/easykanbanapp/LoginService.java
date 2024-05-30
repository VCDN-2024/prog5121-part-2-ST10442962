package easykanbanapp;

import javax.swing.JOptionPane;
import easykanbanapp.LoginService;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginService {
    private Map<String, String> users;

    public LoginService() {
        users = new HashMap<>();
    }

    // Method to register a new user
    public String registerUser(String username, String password, String firstName, String lastName) {
        // Check if username already exists
        if (users.containsKey(username)) {
            return "Username already exists. Please choose a different username.";
        }

        // Validate password complexity
        if (!checkPasswordComplexity(password)) {
            return "Password must contain at least 8 characters, including uppercase, lowercase, digit, and special character.";
        }

        // Add new user to the map
        users.put(username, password);

        // Optionally, you can store additional user information like first name and last name
        // in a separate map or object

        return "User registered successfully.";
    }

    // Method to authenticate a user
    public boolean login(String username, String password) {
        // Check if username exists and password matches
        return users.containsKey(username) && users.get(username).equals(password);
    }

    // Method to check password complexity
    private boolean checkPasswordComplexity(String password) {
        // Use regular expression to enforce password complexity rules
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
