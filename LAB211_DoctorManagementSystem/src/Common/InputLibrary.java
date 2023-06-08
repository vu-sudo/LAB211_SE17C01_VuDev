package Common;

import java.util.Scanner;

public class InputLibrary {
    private Validation validator = new Validation();
    private static final Scanner input = new Scanner(System.in);

    public String setStringValue(String msg, String regex) {
        String stringValue;
        do {
            System.out.print(msg);
            stringValue = input.nextLine().trim();
        } while (!validator.validatePattern(stringValue, regex) || stringValue.length() == 0);
        return stringValue;
    }

    public Integer setIntegerValue(String msg) {
        Integer integerValue = -1;
        boolean passed = false;
        do {
            try {
                System.out.print(msg);
                integerValue = Integer.parseInt(input.nextLine());
                passed = true;
                if (integerValue < 0) {
                    System.out.println("Availability must be equal to or greater than 0! Please enter again!");
                    passed = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        } while (passed == false || integerValue == 0);
        return integerValue;
    }
}
