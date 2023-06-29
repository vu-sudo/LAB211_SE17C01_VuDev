package Controller;

import java.util.ArrayList;

import Common.FunctionsLibrary;
import Common.InputLibrary;
import Model.Task;

public class TaskController {
    private ArrayList<Task> taskList = new ArrayList<>();
    private final FunctionsLibrary functionsLibrary = new FunctionsLibrary();
    private final InputLibrary inputLibrary = new InputLibrary();

    public void handleAddNewTask() {
        String status = "";
        do {
            functionsLibrary.addNewTask(taskList);
            status = inputLibrary.setStringValue("Do you want to continue? (y|Yes|n|No)", "^(Y|y|N|n|YES|yes|NO|no)$").toUpperCase();
        } while (status.equalsIgnoreCase("Y") || status.equalsIgnoreCase("YES"));
        functionsLibrary.display(taskList, "TASK LIST");
    }
    public void handleRemoveTask() {
        functionsLibrary.removeTask(taskList);
        functionsLibrary.display(taskList, "AFTER REMOVE: ");
    }
    public void handleSortTask() {
        ArrayList<Task> tempList = functionsLibrary.sort(taskList);
        functionsLibrary.display(tempList, "SORTED LIST: ");
    }

}
