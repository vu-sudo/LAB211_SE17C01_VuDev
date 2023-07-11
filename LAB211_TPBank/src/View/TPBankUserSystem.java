package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.ManagementService;
import Model.Translator;

public class TPBankUserSystem extends Menu {
    ManagementService managementService = new ManagementService();
    private final Scanner input = new Scanner(System.in);
    
    static Translator translator = new Translator();

    static String[] options = {
            "Create new account",
            "Login System",
            "Exit"
    };

    static String convertStringToBundleKey(String str)  {
        return str.replace(' ', '_');
    }

    public static String[] menuOptions(String[] options) {
        ArrayList<String> resultStringArray = new ArrayList<>();
        for (String str: options) {
            resultStringArray.add(translator.translate(convertStringToBundleKey(str)));
        }
        return resultStringArray.toArray(new String[resultStringArray.size()]);
    }

    // static String[] translatedOptions = menuOptions(options);

    public TPBankUserSystem() {
        super("TP BANK eBank", menuOptions(options));
    }

    void waitForPressAnyKey() {
        System.out.println("\n" + translator.translate("Press_any_key_to_continue"));
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
            default:
                System.out.println(translator.translate("Back_to_languages_memu"));

        }
    }

}
