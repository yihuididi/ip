package yihuibot.executable;

import yihuibot.exception.executable.ExecutableException;
import yihuibot.task.Task;
import yihuibot.task.TaskList;

/**
 * An executable for deleting tasks.
 *
 * @author Toh Yi Hui A0259080A
 */
public class DeleteTask extends TaskModifier {
    private String output;
    private int idx;

    /**
     * Constructor for a new DeleteTask executable.
     *
     * @param idx the 1-index of the tasks to delete.
     */
    public DeleteTask(int idx) {
        super();
        this.idx = idx;
    }

    /**
     * Constructor for a new DeleteTask executable.
     *
     * @param tasks the TaskList to modify.
     * @param idx the 1-index of the tasks to delete.
     */
    public DeleteTask(TaskList tasks, int idx) {
        super(tasks);
        this.idx = idx;
    }

    /**
     * Delete the task from list.
     *
     * @return false.
     * @throws NullPointerException when TaskList is null.
     * @throws ExecutableException when given index is out of bounds of ArrayList.
     */
    @Override
    public boolean execute() throws NullPointerException, ExecutableException {
        if (super.tasks == null) {
            output = "Task list cannot be null.";
            throw new NullPointerException("TaskList cannot be null.");
        }

        try {
            Task task = super.tasks.remove(idx - 1);
            output = "Noted. I've removed this task:\n" + task.toString()
                    + "\nNow you have " + tasks.size() + " task(s) in your list.";
        } catch (IndexOutOfBoundsException e) {
            String message = idx + " index out bounds of task list of size " + super.tasks.size() + ".";
            throw new ExecutableException(message);
        }
        return false;
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
