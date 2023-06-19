package Common;

import java.util.Scanner;

public class InputFunctions {
    private final Scanner input = new Scanner(System.in);
    private Validation validator = new Validation();

    public String getStringValue(String msg, String regex) {
        String stringValue;
        do {
            System.out.print(msg);
            stringValue = input.nextLine().trim();
        } while (!validator.validateInputPattern(stringValue, regex) || stringValue.length() == 0);
        return stringValue;
    }

    
    public String getStringValue(String msg) {
        String stringValue;
        do {
            System.out.print(msg);
            stringValue = input.nextLine().trim();
        } while (stringValue.length() == 0);
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
        } while (passed == false || !validator.validateInputPattern(doubleValue.toString(), regex) || doubleValue == 0);
        return doubleValue;
    } 
}
