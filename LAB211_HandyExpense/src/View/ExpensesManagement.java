package View;

import java.util.Scanner;

import Controller.ExpensesController;

public class ExpensesManagement extends Menu {
    ExpensesController expensesController = new ExpensesController();
    private final Scanner input = new Scanner(System.in);

    static String[] optionsMenu = {
            "Add an expense.",
            "Display expenses list.",
            "Remove an expense by ID",
            "Exit."
    };

    public ExpensesManagement() {
        super("HANDY EXPENSE", optionsMenu);
    }

    void waitForPressAnyKey() {
        System.out.println("\nPress any key to continue...!");
        input.nextLine();
    }

    public void execute(int number) {
        switch (number) {
            case 1:
                expensesController.handleAddExpenses();
                waitForPressAnyKey();
                break;
            case 2:
                expensesController.handleDisplayExpenses();
                waitForPressAnyKey();
                break;
            case 3:
                expensesController.handleRemoveExpenses();
                waitForPressAnyKey();
                break;
            case 4:
                System.out.println("PROGRAM ENDED! THANKS FOR USING!");
            default:
                System.exit(0);
        }
    }
}
