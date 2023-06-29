package View;

import java.util.Scanner;

import Controller.TaskController;

public class TaskManagement extends Menu {
    private final Scanner input = new Scanner(System.in);
    TaskController taskController = new TaskController();
    static String options[] = {
        "Add Task",
        "Delete Task",
        "Display Task",
        "EXIT"
    };

    public TaskManagement() {
        super("TASK PROGRAM", options);
    }
    void pressAnyKeyToContinue() {
        System.out.println("Press any key to continue...");
        input.nextLine();
    }
    @Override
    public void execute(int number) {
        switch (number) {
            case 1 :
                taskController.handleAddNewTask();
                pressAnyKeyToContinue();
                break;
            case 2 :
                taskController.handleRemoveTask();
                pressAnyKeyToContinue();
                break;
            case 3 : 
                taskController.handleSortTask();
                pressAnyKeyToContinue();
                break;
            case 4 :
                System.out.println("EXITED PROGRAM!");
            default: 
                System.exit(0);
        }
    }
    
}
