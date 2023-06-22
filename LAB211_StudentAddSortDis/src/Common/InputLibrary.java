package Common;

import java.util.Scanner;

public class InputLibrary {
    private Validation validator = new Validation();
    private static final Scanner input = new Scanner(System.in);

    public String inputStringValue(String msg, String regex) {
        String stringValue;
        do {
            System.out.print(msg);
            stringValue = input.nextLine().trim();
        } while (!validator.validatePattern(stringValue, regex) || stringValue.length() == 0 || stringValue == null);
        return stringValue;
    }

    public Float inputMark(String msg) {
        Float floatValue = (float) -1;
        boolean passed = false;
        do {
            try {
                System.out.print(msg);
                floatValue = Float.parseFloat(input.nextLine().trim());
                passed = true;
                if (floatValue < 0.0 || floatValue > 100.0) {
                    System.out.println("Mark has to be equal to or greater than 0 and equal to or less than 100!");
                    passed = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number: ");
            }
        } while (passed == false);
        return floatValue;
    }
}
