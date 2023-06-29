package Common;

import java.util.Scanner;

public class InputLibrary {
    private final Scanner input = new Scanner(System.in);
    private final Validation validator = new Validation();
    
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
    public Integer setIntegerValue(String msg) {
        Integer integerValue = -1;
        boolean passed = false;
        do {
            try {
                System.out.print(msg);
                integerValue = Integer.parseInt(input.nextLine());
                passed = true;
                if (integerValue < 1 || integerValue > 4) {
                    System.out.println("Task id must be from 1 to 4!");
                    passed = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        } while (passed == false || integerValue < 1 || integerValue > 4);
        return integerValue;
    }
}
