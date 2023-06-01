package Common;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

import Model.EastAsiaCountries;

public class FunctionsLibrary {
    InputLibrary inputLibrary = new InputLibrary();
    Validation validator = new Validation();
    private boolean isLoadedFile = false;

    public void handleLoadDataFromFile(ArrayList<EastAsiaCountries> eastAsiaCountriesList, String pathLine) {
        if(isLoadedFile) {
            System.out.println("FILE IS LOADED! CANT LOAD AGAIN!");
        } else {
            String path = Paths.get("").toAbsolutePath().toString();
            inputLibrary.loadDataFromFile(path + pathLine, eastAsiaCountriesList);
            isLoadedFile = true;
            displayListOfCountry(eastAsiaCountriesList, "YOUR COUNTRY LIST INPUT FROM FILE: ");
        }
    }

    public EastAsiaCountries inputCountryData() {
        String countryCode = inputLibrary.setStringValue("Enter Country Code: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$").toUpperCase();
        String countryName = validator.normalizeName(inputLibrary.setStringValue("Enter Country Name: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$"));
        Double totalArea = inputLibrary.setDoubleValue("Enter Total of Area: ", "^[-+]?\\d*\\.?\\d+$");
        String countryTerrain = validator.normalizeName(inputLibrary.setStringValue("Enter Country Terrain: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$"));
        return new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain);
    }
    public ArrayList<EastAsiaCountries> search(ArrayList<EastAsiaCountries> eastAsiaCountriesList, Predicate<EastAsiaCountries> eastPredicate) {
        ArrayList<EastAsiaCountries> tempList = new ArrayList<>();
        for(EastAsiaCountries eastAsiaCountries: eastAsiaCountriesList) {
            if(eastPredicate.test(eastAsiaCountries)) tempList.add(eastAsiaCountries); 
        };
        return tempList;
    }

    public ArrayList<EastAsiaCountries> sortIncreasingByName(ArrayList<EastAsiaCountries> eastAsiaCountriesList) {
        ArrayList<EastAsiaCountries> tempArrayList = eastAsiaCountriesList;
        Collections.sort(tempArrayList, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
               return o1.getCountryName().compareTo(o2.getCountryName());
            }
            
        });
        return tempArrayList;
    }

    public void displayListOfCountry(ArrayList<EastAsiaCountries> eastAsiaCountriesList, String msg) {
        if(eastAsiaCountriesList.isEmpty()) {
            System.out.println("COUNTRY LIST IS EMPTY! PLEASE INPUT COUNTRY TO SHOW!");
        } else {
            System.out.println("\n" + msg);
            System.out.println("\n---------------------------------------------------------------------");
            System.out.format("| %5s | %5s | %18s | %15s | %10s |",  "   ","ID", "COUNTRY NAME", "TOTAL AREA", "TERRAIN");
            System.out.println("\n---------------------------------------------------------------------");
            for(EastAsiaCountries eastAsiaCountries : eastAsiaCountriesList) {
                System.out.format("| %5d | %5s | %18s | %15.1f | %10s |",eastAsiaCountriesList.indexOf(eastAsiaCountries) + 1, eastAsiaCountries.getCountryCode(), eastAsiaCountries.getCountryName(), eastAsiaCountries.getTotalArea(), eastAsiaCountries.getCountryTerrain());
                System.out.println("\n---------------------------------------------------------------------");
            }
        }
    }
    public void displayListOfCountry(EastAsiaCountries eastAsiaCountries, Integer index ,String msg) {
        {
            System.out.println("\n" + msg);
            System.out.println("\n---------------------------------------------------------------------");
            System.out.format("| %5s | %5s | %18s | %15s | %10s |",  "   ","ID", "COUNTRY NAME", "TOTAL AREA", "TERRAIN");
            System.out.println("\n---------------------------------------------------------------------");
            System.out.format("| %5d | %5s | %18s | %15.1f | %10s |", index, eastAsiaCountries.getCountryCode(), eastAsiaCountries.getCountryName(), eastAsiaCountries.getTotalArea(), eastAsiaCountries.getCountryTerrain());
            System.out.println("\n---------------------------------------------------------------------");
        }
    }
}
