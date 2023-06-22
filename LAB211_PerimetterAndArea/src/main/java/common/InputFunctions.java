package common;

import java.util.Scanner;

public class InputFunctions {
    private final Scanner input = new Scanner(System.in);
    
    public Double setDoubleValue (String msg) {
        Double doubleValue = 0.0;
        boolean passed = true;
        do {
           try {
                System.out.print(msg);
                doubleValue = Double.valueOf(input.nextLine());
                passed = true;
                if(doubleValue <= 0 ) {
                    System.out.println("This value must be greater than 0! Please try again!");
                    passed = false;
                }
           } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
           }
        } while (passed == false || doubleValue == 0);
        return doubleValue;
    } 

}
