package View;

import java.util.Scanner;

import Controller.FruitManagementService;

public class ExecuteProgram extends Menu{
	private FruitManagementService fruitManagementService = new FruitManagementService();
    private static final Scanner input = new Scanner(System.in);
    static String[] menuOptions = {
            "Input list of fruit",
            "Show order",
            "Ordering (for buyer)",
            "Exit"
        };

        public ExecuteProgram() {
            super("FRUIT MANAGEMENT SYSTEM", menuOptions);
        }
        public void waitForPressAnyKey () {
            System.out.println("Press any key to continue...");
            input.nextLine();
        }
        @Override
        public void execute(int number) {
            switch(number) {
                case 1:
                	fruitManagementService.handleAddFruits();
                    break;
                case 2: 
                	fruitManagementService.handleShowOrder();
                    waitForPressAnyKey();
                    break;
                case 3: 
                	fruitManagementService.handleOrdering();
                    waitForPressAnyKey();
                    break;
                case 4: 
                    System.out.println("EXITED PROGRAM! THANKS FOR YOUR CHECKING!");
                default: 
                    System.exit(0);
                    return;
            }
        }
        public static void main(String[] args) throws Exception {
        	ExecuteProgram exe = new ExecuteProgram();
            exe.run();
        }
}
