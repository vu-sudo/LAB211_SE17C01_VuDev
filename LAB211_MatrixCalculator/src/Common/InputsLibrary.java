package Common;

import java.util.Scanner;

public class InputsLibrary {
    private final Scanner input = new Scanner(System.in);

    public Integer inputValue(String msg) {
        Integer resultInteger = null;
        do {
            try{
                System.out.print(msg);
                resultInteger = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        } while (resultInteger == null);
        return resultInteger;
    }
}