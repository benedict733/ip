package duke.command;

import duke.DukeException;
import duke.Ui;
import duke.Storage;
import duke.task.TaskList;

/**
 * Represents the command to unmark a task as done at the index
 */
public class UnmarkCommand extends Command {
    private final String index;
    /**
     * Returns an UnmarkCommand with the index stored
     *
     * @param index Integer as String
     */
    public UnmarkCommand(String index) {
        super("unmark");
        this.index = index;
    }
    /**
     * Unmarks the task as done at the target index from TaskList
     * Display the output via Ui showing the updated unmarked task
     * Saves the file via Storage
     *
     * @param tasks TaskList of all the tasks
     * @param ui Ui the user interface to interact with the user
     * @param storage Storage used to save the TaskList to be retrieved in the future
     * @throws DukeException if the String index is not an integer OR if index is not in range of size of TaskList
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (tasks.size() == 0) {
            throw new DukeException("You do not have any items in your list!");
        }
        try {
            int idx = Integer.parseInt(this.index);
            tasks.get(idx).setNotDone();
            ui.print(String.format("Nice! I've unmarked this task as done: \n\t%s",
                    tasks.get(idx)));
            storage.saveList(tasks);
        } catch (NumberFormatException notANumber) {
            throw new DukeException("Please enter a valid number");
        }
    }
    @Override
    public String execute(TaskList tasks, Storage storage) throws DukeException {
        if (tasks.size() == 0) {
            throw new DukeException("You do not have any items in your list!");
        }
        try {
            int idx = Integer.parseInt(this.index);
            tasks.get(idx).setNotDone();
            storage.saveList(tasks);
            return String.format("Nice! I've unmarked this task as done: \n\t%s",
                    tasks.get(idx));
        } catch (NumberFormatException notANumber) {
            throw new DukeException("Please enter a valid number");
        }
    }
}
