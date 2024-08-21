package executable;

import java.util.ArrayList;

import task.Task;

import exception.InvalidArgumentException;

/**
 * An executable to mark tasks as done.
 *
 * @author Toh Yi Hui A0259080A
 */
public class MarkTask extends TaskModifier {
    private String output;
    private int idx;

    /**
     * Constructor for a new MarkTask executable.
     * 
     * @param idx the 1-index of the tasks to mark as complete.
     */
    public MarkTask(int idx) {
        super();
        this.idx = idx;
    }

    /**
     * Constructor for a new MarkTask executable.
     *
     * @param tasks the tasks to modify.
     * @param idx the 1-index of the tasks to mark as complete.
     */
    public MarkTask(ArrayList<Task> tasks, int idx) {
        super(tasks);
        this.idx = idx;
    }

    /**
     * Mark the task at idx as completed.
     *
     * @return NORMAL normally, ERROR if tasks == null.
     * @throws InvalidArgumentException when given index is out of bounds of ArrayList.
     */
    @Override
    public exitCode execute() throws InvalidArgumentException {
        if (super.tasks == null) {
            output = "Task list cannot be null.";
            return exitCode.ERROR;
        }

        try {
            Task task = super.tasks.get(idx - 1);
            if (task.markComplete()) {
                output = "Nice! I've marked this task as done:\n" + task.toString();
            } else {
                output = "Task " + idx + " is already completed.";
            }
        } catch (IndexOutOfBoundsException e) {
            String message = idx + " index out bounds of task list of size " + super.tasks.size() + ".";
            throw new InvalidArgumentException(message);
        }
        return exitCode.NORMAL;
    }

    /**
     * Return the output of the executable.
     *
     * @return the output of the executable.
     */
    @Override
    public String getOutput() {
        return output;
    }
}
