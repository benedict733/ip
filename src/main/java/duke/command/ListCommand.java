package duke.command;

import duke.DukeException;
import duke.Ui;
import duke.Storage;
import duke.task.TaskList;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String str = "List:";
        for (int i = 1; i <= tasks.size(); i++) {
            str += String.format("\n\t%d. %s", i, tasks.get(i));
        }
        ui.print(str);
    }
}
