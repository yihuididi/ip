package executable;

import java.util.ArrayList;

import task.Task;

/**
 * An executable for adding tasks.
 *
 * @author Toh Yi Hui A0259080A
 */
public class AddTask extends TaskModifier {
    private String output;
    private Task task;

    /**
     * Constructor for a new AddTask executable.
     *
     * @param task the task to be added.
     */
    public AddTask(Task task) {
        super();
        this.task = task;
    }

    /**
     * Constructor for a new AddTask executable.
     *
     * @param tasks the task list to add the new task into.
     * @param task the task to be added.
     */
    public AddTask(ArrayList<Task> tasks, Task task) {
        super(tasks);
        this.task = task;
    }

    /**
     * Add the task to the list of tasks.
     *
     * @return NORMAL normally, ERROR if tasks == null.
     */
    @Override
    public Executable.exitCode execute() {
        if (tasks == null) {
            output = "Task list cannot be null.";
            return Executable.exitCode.ERROR;
        }

        tasks.add(task);
        output = "Got it. I've added this task:\n" + task.toString()
                + "\nNow you have " + super.tasks.size() + " task(s) in your list.";
        return Executable.exitCode.NORMAL;
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
