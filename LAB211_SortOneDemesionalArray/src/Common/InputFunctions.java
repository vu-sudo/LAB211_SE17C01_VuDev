package Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputFunctions {
    private final Scanner input = new Scanner(System.in);

    public Integer getInputAsNumber(String msg) {
        Integer number = -1;
        do {
            try {
                System.out.println(msg);
                number = Integer.parseInt(input.nextLine().trim());
            } catch (NullPointerException e) {
                System.out.println("Must be a number!");
            }
        } while (number < 0);
        return number; 
    }

    public Integer getInputValueAsInteger(String msg, Integer index) {
        Integer number = 0;
        try {
            System.out.print(msg + " [" + index + "]: " );
            number = Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Must be a number! Please try again!");
        }
        return number;
    }

    public void generateArray(ArrayList<Integer> integersList) {
        integersList.clear();
        int number = getInputAsNumber("Enter number of items in array:");
        Integer[] temp = randomIntegersArray(number);
        integersList.addAll(Arrays.asList(temp));
        
    }

    public void inputItems(ArrayList<Integer> integersList) {
        integersList.clear();
        int number = getInputAsNumber("Enter numberof items in array: ");
        for (int i = 0; i < number; i++) {
            integersList.add(getInputValueAsInteger("Enter item", (i+1)));
        }
    }

    public Integer[] randomIntegersArray(Integer number) {
        Integer[] temp = new Integer[number];
        for (int i = 0; i < temp.length ; i++) {
            temp[i] = (int) (Math.random()*100);
        }
        return temp;
    }
}
