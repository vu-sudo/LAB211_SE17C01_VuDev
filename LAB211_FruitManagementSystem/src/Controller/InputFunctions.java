package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Fruit;

public class InputFunctions {
    private Validation validator = new Validation();
    private static final Scanner input = new Scanner(System.in);

    //checking functions
    public Fruit search(String str, ArrayList<Fruit> fruitsList) {
        str = str.trim().toUpperCase();
        for(Fruit fruit: fruitsList) {
            if(fruit.getFruitId().equals(str)) {
                return fruit;
            }
        }
        return null;
    }
    public boolean isIdDuplicated(String str, ArrayList<Fruit> fruitsList) {
        str = str.trim().toUpperCase();
        return search(str, fruitsList) != null;
    }
    //input functions
    public String inputIdValue(String msg, ArrayList<Fruit> fruitsList, String regex) {
        boolean codeDuplicated = false;
        String resultString;
        do{
            System.out.print(msg);
            resultString = input.nextLine().trim().toUpperCase();
            codeDuplicated = isIdDuplicated(resultString, fruitsList);
            if(codeDuplicated) {
                System.out.println("ID of fruit is duplicate!");
            } 
        } while (codeDuplicated == true || resultString.length() == 0 || !validator.validatePattern(resultString, regex));
        return resultString;
    }

    public String inputStringValue(String msg, String regex) {
        String resultString;
        do {
            System.out.print(msg);
            resultString = input.nextLine().trim();
        } while(!validator.validatePattern(resultString, regex));
        return resultString;
    }

    public Integer inputNumberValue(String msg, String regex) {
        Integer resultInt = 0;
        do {
            try {
                System.out.print(msg);
                resultInt = Integer.parseInt(input.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Must be a number!");
            }
        } while (resultInt == 0 || !validator.validatePattern(resultInt.toString(), regex));
        return resultInt;
    }

}
