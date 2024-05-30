
package easykanbanapp;
import java.util.Scanner;

public class Login1 {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    // Method to check Uername format
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check Password Complexity
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") && 
               password.matches(".*[0-9].*") && 
               password.matches(".*[^a-zA-Z0-9].*");
    }

    // Method to register a User
    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        } else {
            this.username = username;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
            return "User registered successfully.";
        }
    }

    // Method to verify user login
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Method to return login Status
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + this.firstName + " " + this.lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again";
        }
    }
}
