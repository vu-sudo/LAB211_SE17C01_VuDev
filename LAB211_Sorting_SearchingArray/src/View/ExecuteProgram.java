package View;

import Controller.ProgramController;

import java.util.Scanner;

public class ExecuteProgram  extends Menu{
    ProgramController service = new ProgramController();
    private final Scanner scan = new Scanner(System.in);
    static String[] MenuOption = {
            "Generate Array.",
            "Sort Array",
            "Search Array Element",
            "EXIT"
    };
    public ExecuteProgram() {
        super("BUBBLE SORT AND QUICK SORT", MenuOption);
    }
    public void waitForPressAnyKey () {
        System.out.println("Press any key to continue...");
        scan.nextLine();
    }
    @Override
    public void execute(int number) {
        switch (number) {
            case 1:
                service.generateArray();
                waitForPressAnyKey();
                break;
            case 2:
                handleSortFunctions();
                break;
            case 3:
                handleSearchFunction();
                break;
            case 4:
                System.out.println("EXITED PROGRAM!");
            default:
                System.exit(0);
        }
    }
    public void handleSortFunctions() {
        String[] eMenu = {
                "Bubble Sort",
                "Quick Sort",
        };
        Menu menu = new Menu("CHOOSE YOUR SORTED FUNCTION:", eMenu) {
            @Override
            public void execute(int number) {
                    switch (number) {
                        case 1:
                            if(service.returnArray().isEmpty()) {
                                System.out.println("Your number list is EMPTY!, can't execute this function!");
                                waitForPressAnyKey();
                                break;
                            } else {
                                System.out.println("BEFORE SORTING ARRAY:");
                                service.displayArray();
                                System.out.println("AFTER SORTING ARRAY:");
                                service.executeBubbleSort();
                                service.displayArray();
                            }
                            waitForPressAnyKey();
                            break;
                        case 2:
                            if(service.returnArray().isEmpty()) {
                                System.out.println("Your number list is EMPTY!, can't execute this function!");
                                waitForPressAnyKey();
                                break;
                            } else {
                                System.out.println("BEFORE SORTING ARRAY:");
                                service.displayArray();
                                System.out.println("AFTER SORTING ARRAY:");
                                service.executeQuickSort();
                                service.displayArray();
                            }
                            waitForPressAnyKey();
                            break;
                        default:
                            System.out.println("BACKED TO MAIN MENU!");
                    }
            }
        };
        menu.run();
    }
    public void handleSearchFunction() {
        String[] eMenu = {
                "Linear Search",
                "Binary Search",
        };
        Menu menu = new Menu("CHOOSE YOUR SEARCH FUNCTION", eMenu) {
            @Override
            public void execute(int number) {
                switch (number) {
                    case 1:
                        handleLinearSearch();
                        break;
                    case 2:
                        handleBinarySearch();
                        break;
                    default:
                }
            }
        };
        menu.run();
    }
    public void handleLinearSearch() {
        if(service.returnArray().isEmpty()) {
            System.out.println("Your number list is EMPTY!, can't execute this function!");
        } else {
            service.executeLinearSearch();
        }
        waitForPressAnyKey();
    }
    public void handleBinarySearch() {
        if(service.returnArray().isEmpty()) {
            System.out.println("Your number list is EMPTY!, can't execute this function!");
        } else {
            service.executeBinarySearch();
        }
        waitForPressAnyKey();
    }
    public static void main(String[] args) {
        ExecuteProgram exe = new ExecuteProgram();
        exe.run();
    }
}
