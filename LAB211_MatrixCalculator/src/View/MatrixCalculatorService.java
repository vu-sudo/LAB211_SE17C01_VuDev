package View;

import java.util.Scanner;

import Controller.MatrixCalculatorController;

public class MatrixCalculatorService extends Menu{
    MatrixCalculatorController matrixCalculatorController = new MatrixCalculatorController();
    private final Scanner input = new Scanner(System.in);

    static String[] optionsMenu = {
            "Add 2 matrices.",
            "Subtract 2 matrices",
            "Multiply 2 matrices",
            "Exit."
    };

    public MatrixCalculatorService() {
        super("MATRICES CALCULATOR", optionsMenu);
    }

    void waitForPressAnyKey() {
        System.out.println("\nPress any key to continue...!");
        input.nextLine();
    }

    public void execute(int number) {
        switch (number) {
            case 1:
                matrixCalculatorController.handleAddMatrix();
                waitForPressAnyKey();
                break;
            case 2:
                matrixCalculatorController.handleSubtractMatrix();
                waitForPressAnyKey();
                break;
            case 3:
                matrixCalculatorController.handleMultiplyMatrix();
                waitForPressAnyKey();
                break;
            case 4:
                System.out.println("PROGRAM ENDED! THANKS FOR USING!");
            default:
                System.exit(0);
        }
    }
}