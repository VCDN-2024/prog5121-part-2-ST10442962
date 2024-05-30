package easykanbanapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void testTaskConstructor() {
        Task task = new Task("Develop", 1, "Implement feature X", "John Doe", 5, "To Do");
        assertEquals("Develop", task.getTaskName());
        assertEquals(1, task.getTaskNumber());
        assertEquals("Implement feature X", task.getTaskDescription());
        assertEquals("John Doe", task.getDeveloperDetails());
        assertEquals(5, task.getTaskDuration());
        assertEquals("To Do", task.getTaskStatus());
        assertEquals("DE:1:DOE", task.getTaskID());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskDescriptionTooLong() {
        new Task("Develop", 1, "This description is definitely longer than fifty characters, which is not allowed.", "John Doe", 5, "To Do");
    }

    @Test
    public void testSetTaskDescriptionValid() {
        Task task = new Task("Develop", 1, "Valid description", "John Doe", 5, "To Do");
        task.setTaskDescription("New valid description");
        assertEquals("New valid description", task.getTaskDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTaskDescriptionInvalid() {
        Task task = new Task("Develop", 1, "Valid description", "John Doe", 5, "To Do");
        task.setTaskDescription("This description is definitely longer than fifty characters, which is not allowed.");
    }

    @Test
    public void testCheckTaskDescription() {
        Task task = new Task("Develop", 1, "Valid description", "John Doe", 5, "To Do");
        assertTrue(task.checkTaskDescription());

        // Setting a description directly
        task.setTaskDescription("Short description");
        assertTrue(task.checkTaskDescription());
    }

    @Test
    public void testCreateTaskID() {
        Task task = new Task("Develop", 1, "Valid description", "John Doe", 5, "To Do");
        assertEquals("DE:1:DOE", task.createTaskID());

        Task shortNameTask = new Task("A", 2, "Short name description", "Jane Smith", 3, "Done");
        assertEquals("A:2:ITH", shortNameTask.createTaskID());

        Task shortDeveloperTask = new Task("Feature", 3, "Another description", "Bob", 8, "Doing");
        assertEquals("FE:3:BOB", shortDeveloperTask.createTaskID());
    }

    @Test
    public void testPrintTaskDetails() {
        Task task = new Task("Develop", 1, "Valid description", "John Doe", 5, "To Do");
        String expected = "Task Status: To Do\nDeveloper Details: John Doe\nTask Number: 1\nTask Name: Develop\nTask Description: Valid description\nTask ID: DE:1:DOE\nTask Duration: 5 hours";
        assertEquals(expected, task.printTaskDetails());
    }

    @Test
    public void testGetTaskDuration() {
        Task task = new Task("Develop", 1, "Valid description", "John Doe", 5, "To Do");
        assertEquals(5, task.getTaskDuration());
    }
}


