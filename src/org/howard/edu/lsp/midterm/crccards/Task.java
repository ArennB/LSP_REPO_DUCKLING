package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task in the Task Management System.
 * Stores task information, allows status updates, and provides task details.
 *
 * @author arenn
 */
public class Task {
    private final String taskId;
    private final String description;
    private String status;

    /**
     * Constructs a new Task with the given taskId and description. Status defaults to "OPEN".
     *
     * @param taskId the unique task ID
     * @param description the task description
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task's ID.
     *
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task's description.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the current status of the task.
     *
     * @return the task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the task. If the status is not valid, sets to "UNKNOWN".
     *
     * @param status the new status (must be "OPEN", "IN_PROGRESS", or "COMPLETE")
     */
    public void setStatus(String status) {
        if ("OPEN".equals(status) || "IN_PROGRESS".equals(status) || "COMPLETE".equals(status)) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns a string representation of the task in the format: taskId description [status]
     *
     * @return string representation
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}
