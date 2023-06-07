package View;

import java.util.Scanner;

import Controller.ProgramController;

public class ExecuteProgram extends Menu {
    ProgramController programController = new ProgramController();
    private final Scanner input = new Scanner(System.in);

    static String[] options = {
        "Input items of the Array",
        "Sort the array in ascending order",
        "Sort the array in descending order",
        "Exit Program",
    };

    public ExecuteProgram() {
        super("BUBBLE SORT PROGRAM", options);
    }
    void waitForPressAnyKey() {
        System.out.println("\nPress any key to continue...");
        input.nextLine();
    }
    @Override
    public void execute(int number) {
        switch(number) {
            case 1:
                programController.handleInputItems(); 
                waitForPressAnyKey();
                break;
            case 2:
                programController.handleSortAscending(); 
                waitForPressAnyKey();
                break;
            case 3:
                programController.handleSortDescending(); 
                waitForPressAnyKey();
                break;
            case 4:
                System.out.println("EXITED PROGRAM!");
            default:
                System.exit(0);
        }
    }
    public static void main(String[] args) {
        ExecuteProgram exe = new ExecuteProgram();
        exe.run();
    }
}
