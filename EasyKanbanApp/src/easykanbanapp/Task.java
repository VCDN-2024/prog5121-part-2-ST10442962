package easykanbanapp;

public final class Task {
    private final String taskName;
    private final int taskNumber;
    private String taskDescription;
    private final String developerDetails;
    private final int taskDuration;
    private final String taskID;
    private final String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        setTaskDescription(taskDescription);
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskDescription(String taskDescription) {
        if (taskDescription.length() <= 50) {
            this.taskDescription = taskDescription;
        } else {
            throw new IllegalArgumentException("Please enter a task description of less than 50 characters");
        }
    }

    public boolean checkTaskDescription() {
        return this.taskDescription.length() <= 50;
    }

    public String createTaskID() {
        String taskNameInitials = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String[] developerNameParts = developerDetails.split(" ");
        String developerLastName = developerNameParts.length > 1 ? developerNameParts[1] : developerDetails;
        String developerInitials = developerLastName.length() >= 3 ? developerLastName.substring(developerLastName.length() - 3).toUpperCase() : developerLastName.toUpperCase();
        return taskNameInitials + ":" + taskNumber + ":" + developerInitials;
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus +
               "\nDeveloper Details: " + developerDetails +
               "\nTask Number: " + taskNumber +
               "\nTask Name: " + taskName +
               "\nTask Description: " + taskDescription +
               "\nTask ID: " + taskID +
               "\nTask Duration: " + taskDuration + " hours";
    }
}

