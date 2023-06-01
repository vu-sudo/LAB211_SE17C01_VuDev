package Controller;

import java.util.ArrayList;

import Common.FunctionsLibrary;
import Common.InputLibrary;
import Common.Validation;
import Model.EastAsiaCountries;
import View.Menu;

public class GeographyManagement {
    FunctionsLibrary functionsLibrary = new FunctionsLibrary();
    InputLibrary inputLibrary = new InputLibrary();
    Validation validator = new Validation();
    boolean isDataLoadFromFile = false;

    ArrayList<EastAsiaCountries> eastAsiaCountriesList = new ArrayList<>();

    public void setInputByLoadDataFromFile() {
        functionsLibrary.handleLoadDataFromFile(eastAsiaCountriesList, "/src/Data/AsianSource.txt");
        isDataLoadFromFile = true;
    }
    public void setInputManual() {
        String status = "";
        isDataLoadFromFile = false;
        do {
            if(eastAsiaCountriesList.size() < 11) {
                eastAsiaCountriesList.add(functionsLibrary.inputCountryData());
                if(eastAsiaCountriesList.size() == 11) break;
                System.out.println("Do you want to continue?");
                status = inputLibrary.setStringValue("Enter yY-YES or nN-NO: ", "^(Y|y|N|n|YES|yes|NO|no)$").toUpperCase();    
            }
        } while (status.equalsIgnoreCase("Y") || status.equalsIgnoreCase("YES"));
    }
    public void handleInputCountryData() {
        String[] options = {
            "Load data from file.",
            "Manual input."
        };

        Menu eMenu = new Menu("INPUT FUNCTIONS", options) {

            @Override
            public void execute(int number) {
                switch(number) {
                    case 1: 
                        setInputByLoadDataFromFile();
                        break;
                    case 2: 
                        if(eastAsiaCountriesList.size() == 11) {
                            System.out.println("List of Country is full (11 countries)");
                        } else {
                            setInputManual();
                        }
                        break;
                    default: 
                        System.out.println("Backed to main menu!");
                        return;
                }
            }  
        };
        eMenu.run();
    }
    public void handleDisplayElementJustEnter() {
         if(isDataLoadFromFile) {
            System.out.println("Data is loaded from file, have no last entry!");
         } else {
            functionsLibrary.displayListOfCountry(eastAsiaCountriesList.get(eastAsiaCountriesList.size() - 1),eastAsiaCountriesList.size(),"THE ELEMENT YOU HAVE JUST ENTER: ");
         }
    }
    public void handleSearchCountry() {
        if(eastAsiaCountriesList.isEmpty()) {
            System.out.println("EMPTY LIST! CANT IMPLEMENT THIS FUNCTION!");
        } else {
                String countryName = validator.normalizeName(inputLibrary.setStringValue("Enter Country Name to search: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$"));
                ArrayList<EastAsiaCountries> tempArrayList = functionsLibrary.search(eastAsiaCountriesList, eastAsiaCountries -> (eastAsiaCountries.getCountryName().contains(countryName)));
                if(tempArrayList.isEmpty()) {
                    System.out.println("Do not have any country have the name " + countryName);
                } else {
                    functionsLibrary.displayListOfCountry(tempArrayList, "LIST OF COUNTRY HAVE THE NAME: " + countryName.toUpperCase());
                }
        }
     }
     public void handleSortListOfCountries() {
        if(eastAsiaCountriesList.isEmpty()) {
            System.out.println("EMPTY LIST! CANT IMPLEMENT THIS FUNCTION!");
        } else {
            ArrayList<EastAsiaCountries> tempArrayList = functionsLibrary.sortIncreasingByName(eastAsiaCountriesList);
            functionsLibrary.displayListOfCountry(tempArrayList, "SORTED LIST INCREASING BY NAME: ");
        }
     }
}
