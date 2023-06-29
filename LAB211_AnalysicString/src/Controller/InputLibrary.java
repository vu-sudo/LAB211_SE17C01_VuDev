package Controller;

import java.util.Scanner;

public class InputLibrary {

    private final Scanner input = new Scanner(System.in);

    public String setStringValue(String msg) {
        String stringValue;
        do {
            System.out.print(msg);
            stringValue = input.nextLine().trim();
        } while (stringValue.length() == 0);
        return stringValue;
    }
    
}
