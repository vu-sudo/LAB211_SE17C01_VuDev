package View;

import java.util.Scanner;

import Controller.GeographyManagement;

public class ManageEastAsiaCountries extends Menu {

    GeographyManagement geographyManagement = new GeographyManagement();
    private final Scanner input = new Scanner(System.in);

    static String[] optionsMenu = {
        "Input the information of 11 countries in East Asia.",
        "Display the information of country you've just input.",
        "Search the information of country by user-entered name.",
        "Display the information of countries sorted name in ascending order",
        "Exit!"
    };

    public ManageEastAsiaCountries() {
        super("EAST ASIAN COUNTRIES MANAGEMENT SYSTEM", optionsMenu);
    }
    
    void waitForPressAnyKey() {
        System.out.println("\nPress any key to continue...!");
        input.nextLine();
    }

    @Override
    public void execute(int number) {
        switch(number) {
            case 1: 
                geographyManagement.handleInputCountryData();
                waitForPressAnyKey();
                break;
            case 2:
                geographyManagement.handleDisplayElementJustEnter();
                waitForPressAnyKey();
                break;
            case 3:
                geographyManagement.handleSearchCountry();
                waitForPressAnyKey();
                break;
            case 4:    
                geographyManagement.handleSortListOfCountries();
                waitForPressAnyKey();
                break;
            case 5:
                System.out.println("PROGRAM END! THANKS FOR USING!");
            default: 
                System.exit(0);
        }
    }
    public static void main(String[] args) {
        ManageEastAsiaCountries exe = new ManageEastAsiaCountries();
        exe.run();
    }
}
