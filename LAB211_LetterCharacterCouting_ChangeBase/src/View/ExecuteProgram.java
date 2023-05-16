package View;

import Controller.ProgramController;

import java.util.Scanner;

public class ExecuteProgram extends Menu {
    ProgramController sevice = new ProgramController();
    private final Scanner scan = new Scanner(System.in);
    static String[] Menu = {
            "Words and Characters counting.",
            "Number converter",
            "Exit."
    };
    public ExecuteProgram() {
        super("String counter and Number Converter", Menu);
    }
    public void waitForPressAnyKey () {
        System.out.println("Press any key to continue...");
        scan.nextLine();
    }
    @Override
    public void execute(int number) {
        switch (number) {
            case 1:
                sevice.handleCounting();
                waitForPressAnyKey();
                break;
            case 2:
                sevice.handleChangeBase();
                waitForPressAnyKey();
                break;
            case 3:
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