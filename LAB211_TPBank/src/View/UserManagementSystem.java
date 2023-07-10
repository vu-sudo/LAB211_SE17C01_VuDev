package View;

import java.util.Scanner;

import Controller.ManagementService;


public class UserManagementSystem extends Menu {
    ManagementService managementService = new ManagementService();
    private final Scanner input = new Scanner(System.in);
    

    static String[] options = {
            "Create new account",
            "Login System",
            "Exit"
    };

    public UserManagementSystem() {
        super("USER MANAGEMENT SYSTEM", options);
    }

    void waitForPressAnyKey() {
        System.out.println("\nPress any key to continue...");
        input.nextLine();
    }

    @Override
    public void execute(int number) {
        switch (number) {
            case 1:
                managementService.handleCreateNewUserAccount();
                waitForPressAnyKey();
                break;
            case 2:
                managementService.handeLogin();
                waitForPressAnyKey();
                break;
            case 3:
                System.out.println("Program exited!");
            default:
                System.exit(0);
        }
    }

}
