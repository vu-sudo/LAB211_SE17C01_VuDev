package View;

import java.util.Scanner;

import Controller.QuadraticEquation;
import Controller.SuperlativeEquation;


public class ExecuteProgram extends Menu {
    QuadraticEquation quadraticEquation = new QuadraticEquation();
    SuperlativeEquation superlativeeEquation = new SuperlativeEquation();

    private final Scanner input = new Scanner(System.in);

    static String[] menuOptions = {
        "Calculate Superlative Equation",
        "Calculate Quadratic Equation",
        "Exit Program",
    };

    public ExecuteProgram() {
        super("EQUATION PROGRAM", menuOptions);
    }

    void waitForPressAnyKey() {
        System.out.println("\nPress any key to continue...");
        input.nextLine();
    }

    @Override
    public void execute(int number) {
        switch(number) {
            case 1: 
                superlativeeEquation.handleSetSuperlativeData();
                waitForPressAnyKey();
                break;
            case 2: 
                quadraticEquation.handleSetQuadraticData();
                waitForPressAnyKey();
                break;
            case 3:
                System.out.println("Thanks you for checking my program!");
            default: 
                System.exit(0);
        } 
    }
    public static void main(String[] args) {
        ExecuteProgram exe = new ExecuteProgram();
        exe.run();
    }
}
