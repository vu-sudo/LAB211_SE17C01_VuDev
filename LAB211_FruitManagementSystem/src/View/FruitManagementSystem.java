package View;

import java.util.Scanner;

import Controller.FruiManagementService;

public class FruitManagementSystem extends Menu {
    private final Scanner input = new Scanner(System.in);
    private FruiManagementService fruiManagementService = new FruiManagementService();

    static String[] options = {
        "Create Fruit",
        "View Orders",
        "Shopping (for buyer)",
        "Exit system"
    };

    public FruitManagementSystem() {
        super("FRUIT SHOP SYSTEM", options);
    }
    public void waitForPressAnyKey () {
        System.out.println("Press any key to continue...");
        input.nextLine();
    }
    @Override
    public void execute(int number) {
        switch(number) {
            case 1:
                fruiManagementService.handleCreateList();
                break;
            case 2:
                fruiManagementService.handleDisplayCustomerList();
                break;
            case 3:
                fruiManagementService.handleShoppingFunction();
                break;
            case 4:
                System.out.println("EXITED PROGRAM!");
            default:
                System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        FruitManagementSystem exe = new FruitManagementSystem();
        exe.run();
    }

}
