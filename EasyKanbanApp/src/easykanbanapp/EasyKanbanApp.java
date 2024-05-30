package easykanbanapp;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EasyKanbanApp {
    private static final List<Task> tasks = new ArrayList<>();
    private static int totalHours = 0;

    private static String registeredUsername;
    private static String registeredPassword;
    private static String name;
    private static String surname;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        register();
        if (login()) {
            mainMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect login credentials. Exiting application.");
            System.exit(0);
        }
    }

    private static void register() {
        name = JOptionPane.showInputDialog("Enter your name:");
        surname = JOptionPane.showInputDialog("Enter your surname:");
        registeredUsername = JOptionPane.showInputDialog("Create a username:");
        registeredPassword = JOptionPane.showInputDialog("Create a password:");

        if (name == null || surname == null || registeredUsername == null || registeredPassword == null) {
            JOptionPane.showMessageDialog(null, "Registration cancelled. Exiting application.");
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null, "Registration successful! Please login to continue.");
    }

    private static boolean login() {
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        if (username == null || password == null) {
            return false; // If user cancels the input dialogs, consider it a failed login
        }

        username = username.trim();
        password = password.trim();

        return registeredUsername.equals(username) && registeredPassword.equals(password);
    }

    private static void mainMenu() {
        while (true) {
            String[] options = {"Add tasks", "Show report", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Main Menu", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addTasks();
                    break;
                case 1:
                    showReport();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
            }
        }
    }

    private static void addTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
            String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
            String[] statuses = {"To Do", "Done", "Doing"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status", "Task Status",
                    JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);

            try {
                Task task = new Task(taskName, tasks.size(), taskDescription, developerDetails, taskDuration, taskStatus);
                tasks.add(task);
                totalHours += task.getTaskDuration();
                JOptionPane.showMessageDialog(null, "Task successfully captured\n" + task.printTaskDetails());
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                i--; // Retry the current task
            }
        }
        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }

    private static void showReport() {
        JOptionPane.showMessageDialog(null, "Coming Soon");
    }
}

// Placeholder for the Task class definition
class Task {
    private String taskName;
    private int taskID;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskStatus;

    public Task(String taskName, int taskID, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        if (taskDescription.length() > 50) {
            throw new IllegalArgumentException("Task description should be 50 characters or less.");
        }
        this.taskName = taskName;
        this.taskID = taskID;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String printTaskDetails() {
        return "Task ID: " + taskID + "\nTask Name: " + taskName + "\nTask Description: " + taskDescription + 
                "\nDeveloper Details: " + developerDetails + "\nTask Duration: " + taskDuration + " hours" + 
                "\nTask Status: " + taskStatus;
    }
}
