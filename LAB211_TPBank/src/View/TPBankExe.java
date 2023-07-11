package View;

import Model.Translator;

public class TPBankExe extends Menu {
    Translator translator = new Translator();

    static String[] options = {
        "Vietnamese",
        "English",
        "Exit"
    };

    public TPBankExe() {
        super("TP BANK WELCOME", options);
    }

    @Override
    public void execute(int number) {
        switch(number) {
            case 1:
                translator.setLanguageSwitcherLocale("vi");
                TPBankUserSystem tpBankUserSystem = new TPBankUserSystem();             
                tpBankUserSystem.run();
                break;
            case 2:
                translator.setLanguageSwitcherLocale("en");
                tpBankUserSystem = new TPBankUserSystem();
                tpBankUserSystem.run();
                break;
            case 3: 
                System.out.println("Program exited");
            default: 
                System.exit(0);
       }
    }
    
}
