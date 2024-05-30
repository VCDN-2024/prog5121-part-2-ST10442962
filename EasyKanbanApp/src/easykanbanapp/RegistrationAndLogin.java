
package easykanbanapp;
import java.util.Scanner;

public class RegistrationAndLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();
        
        // Registration
        System.out.println("Please enter your desired username:");
        String username = scanner.nextLine();
        
        System.out.println("Please enter your desired password:");
        String password = scanner.nextLine();
        
        System.out.println("Please enter your first name:");
        String firstName = scanner.nextLine();
        
        System.out.println("Please enter your last name:");
        String lastName = scanner.nextLine();
        
        String registrationMessage = loginSystem.registerUser(username, password, firstName, lastName);
        System.out.println(registrationMessage);
        
        if(registrationMessage.equals("User registered successfully.")) {
            // Login
            System.out.println("Please login with your new account.");
            System.out.println("Username:");
            String loginUsername = scanner.nextLine();
            
            System.out.println("Password:");
            String loginPassword = scanner.nextLine();
            
            boolean loginSuccess = loginSystem.loginUser(loginUsername, loginPassword);
           
        }
        
        scanner.close();
    }
}
