package View;

import java.util.Scanner;

import Controller.ContactManagement;

public class ContactManagementProgram extends Menu {
    ContactManagement contactManagement = new ContactManagement();
    private final Scanner input = new Scanner(System.in);

    static String[] optionsMenu = {
            "Add a contact.",
            "Display all contacts.",
            "Delete a contact by ID",
            "Exit"
    };

    public ContactManagementProgram() {
        super("CONTACT MANAGEMENT SYSTEM", optionsMenu);
    }

    void waitForPressAnyKey() {
        System.out.println("\nPress any key to continue...!");
        input.nextLine();
    }

    public void execute(int number) {
        switch (number) {
            case 1:
                contactManagement.handleInputContact();
                waitForPressAnyKey();
                break;
            case 2:
                contactManagement.handleDisplayContactList();
                waitForPressAnyKey();
                break;
            case 3:
                contactManagement.handleRemoveContact();
                waitForPressAnyKey();
                break;
            case 4:
                System.out.println("PROGRAM ENDED! THANKS FOR USING!");
            default:
                System.exit(0);
        }
    }

    public static void main(String[] args) throws Exception {
        ContactManagementProgram exe = new ContactManagementProgram();
        exe.run();
    }
}
