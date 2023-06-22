package View;

import java.util.Scanner;

import Controller.DictionaryManagement;

public class DictionaryManagementService extends Menu {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    private final Scanner input = new Scanner(System.in);

    static String[] optionsMenu = {
            "Add a word and its meaning.",
            "Remove a word.",
            "Translate a word.",
            "Exit."
    };

    public DictionaryManagementService() {
        super("Simple English - Vietnamese Dictionary", optionsMenu);
    }

    void waitForPressAnyKey() {
        System.out.println("\nPress any key to continue...!");
        input.nextLine();
    }

    public void execute(int number) {
        switch (number) {
            case 1:
                dictionaryManagement.handleAddNewWord();
                waitForPressAnyKey();
                break;
            case 2:
                dictionaryManagement.handleRemoveWord();
                waitForPressAnyKey();
                break;
            case 3:
                dictionaryManagement.handleTranslateWord();
                waitForPressAnyKey();
                break;
            case 5:
                System.out.println("PROGRAM ENDED! THANKS FOR USING!");
            default:
                System.exit(0);
        }
    }

}
