package Common;

import java.util.Scanner;

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

    public Integer setIntegerValue(String msg) {
        Integer integerValue = 0;
        boolean passed = true;
        do {
            try {
                System.out.print(msg);
                integerValue = Integer.parseInt(input.nextLine());
                passed = true;
                if (integerValue <= 0) {
                    System.out.println("ID is greater than 0! Please enter again!");
                    passed = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        } while (passed == false || integerValue == 0);
        return integerValue;
    }
}
