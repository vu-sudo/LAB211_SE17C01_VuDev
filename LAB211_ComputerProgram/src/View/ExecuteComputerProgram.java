package View;

import java.util.Scanner;

import Controller.ComputerControl;

public class ExecuteComputerProgram extends Menu{
    ComputerControl computerControl = new ComputerControl();
    private final Scanner input = new Scanner(System.in);

    static String[] options = {
        "Calculator",
        "BMI Calculator",
        "Exit"
    };

    public ExecuteComputerProgram() {
        super("COMPUTER PROGRAM", options);
    }

    void waitForPressAnyKey() {
        System.out.println("Press any key to continue...");
        input.nextLine();
    }

    @Override
    public void execute(int number) {
        switch(number) {
            case 1: 
                computerControl.handleExecuteComputerProgram();
                waitForPressAnyKey();
                break;
            case 2:
                computerControl.handleCalculationBMI();
                waitForPressAnyKey();
                break;
            case 3: 
                System.out.println("THE PROGRAM IS END!");
            default: 
                System.exit(0);
        }
    }
    public static void main(String[] args) {
        ExecuteComputerProgram exe = new ExecuteComputerProgram();
        exe.run();
    }
}
