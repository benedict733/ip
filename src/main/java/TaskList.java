import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

public class TaskList {
    private ArrayList<Task> tasks;
    public TaskList() {
        this(new ArrayList<Task>());
    }
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
    public Task get(int index) throws DukeException {
        try {
            return tasks.get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(String.format(
                    "Please enter a number from 1 to %d",
                    this.size()));
        }
    }
    public int size() {
        return tasks.size();
    }
    // below is unfactored properly yet
    public void add(Task task) {
        this.tasks.add(task);
    }
    public String delete(int index) throws DukeException {
        if (size() == 0) {
            throw new DukeException("You do not have any items in your list!");
        }
        try {
            String taskDescription = this.get(index).toString();
            this.tasks.remove(index-1);
            return taskDescription;
        } catch (IndexOutOfBoundsException badNumber) {
            throw new DukeException(String.format(
                    "Please enter a number from 1 to %d",
                    this.size()));
        }
    }
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }
}
