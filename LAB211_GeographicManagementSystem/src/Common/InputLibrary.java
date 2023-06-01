package Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import Model.EastAsiaCountries;

public class InputLibrary {
    private final Scanner input = new Scanner(System.in);
    Validation validator = new Validation();

    public String setStringValue(String msg, String regex) {
        String stringValue;
        do {
            System.out.print(msg);
            stringValue = input.nextLine().trim();
        } while (!validator.validatePattern(stringValue, regex) || stringValue.length() == 0);
        return stringValue;
    }

    public Double setDoubleValue (String msg, String regex) {
        Double doubleValue = 0.0;
        boolean passed = true;
        do {
           try {
                System.out.print(msg);
                doubleValue = Double.parseDouble(input.nextLine());
                passed = true;
                if(doubleValue <= 0 ) {
                    System.out.println("This value must be greater than 0! Please try again!");
                    passed = false;
                }
           } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
           }
        } while (passed == false || !validator.validatePattern(doubleValue.toString(), regex) || doubleValue == 0);
        return doubleValue;
    } 

    public void loadDataFromFile(String fName, ArrayList<EastAsiaCountries> eastAsiaCountriesList) {
        File file = new File(fName);
        if(!file.exists()) {
            throw new RuntimeException("This file isn't exist!");
        }
        String line = "";
        try {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fName)))){
                while ((line = bufferedReader.readLine()) != null) {
                    String[] lStrings = line.split("-");
                    eastAsiaCountriesList.add(new EastAsiaCountries(lStrings[0], lStrings[1], Double.parseDouble(lStrings[2]), lStrings[3]));
                }
            }
        } catch (Exception e) {
            System.out.println("Load file failed!");
        }
        System.out.println("LOAD FILE SUCESSFULLY!");
    }
}
