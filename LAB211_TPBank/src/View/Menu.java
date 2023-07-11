package View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Model.Translator;

public abstract class Menu {
    private final Scanner input = new Scanner(System.in);
    private String title;
    private ArrayList<String> options = new ArrayList<>();

    Translator translator = new Translator();

    public Menu(String titel, String[] options) {
        this.title = titel;
        this.options.addAll(Arrays.asList(options));
    }

    public void menuDisplay() {
        System.out.println("\n=============================================");
        System.out.println(this.title);
        System.out.println("=============================================");
        for(int i = 0; i < options.size(); i++) {
            System.out.println((i+1) + ". " + options.get(i));
        }
        System.out.println("=============================================");
    }

    public Integer getChoice() {
        menuDisplay();
        int choice = 0;
        System.out.print(translator.translate("Enter_number's_option"));
        while(choice == 0) {
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.err.println(translator.translate("Your_choice_must_be_a_number"));
            }
        }
        return choice;
    }

    public void run() {
        while(true) {
            int choice = getChoice();
            execute(choice);
            if(choice >= options.size()) break;
        }
    }
    public abstract void execute(int number);
}