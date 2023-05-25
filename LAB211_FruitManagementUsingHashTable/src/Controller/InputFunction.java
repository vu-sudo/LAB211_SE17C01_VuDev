package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Fruit;

public class InputFunction {
	private Validation validator = new Validation();
	private static final Scanner input = new Scanner(System.in);
	
	public String inputId(String msg, ArrayList<Fruit> fruitsList) {
		boolean codeDuplicated = false;
		String resultString;
		do {
			System.out.print(msg);
			resultString = input.nextLine().trim().toUpperCase();
			codeDuplicated = validator.isDuplicated(resultString, fruitsList);
			if (codeDuplicated) {
				System.out.println("ID is duplicated");
			}
		} while (codeDuplicated == true || resultString.length() == 0 || !validator.validatePattern(resultString, "^[fF]\\d+$"));
		return resultString;
	}
	
	public String inputFruit(String msg) {
		String resultString;
		do {
			System.out.print(msg);
			resultString = input.nextLine().trim();
		} while (!validator.validatePattern(resultString, "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$"));
		return resultString;
	}
	
	public Integer inputNumber(String msg) {
        int number = 0;
        while(number == 0) {
           try {
                System.out.print(msg);
                number = Integer.parseInt(input.nextLine());
           } catch (NumberFormatException e) {
                System.out.println("Must be a number!");
           }
        }
        return number;
	}
	
	public String inputOrigin(String msg) {
		String resultString;
		do {
			System.out.print(msg);
			resultString = input.nextLine();
		} while (!validator.validatePattern(resultString, "^[a-zA-Z]{1,20}$"));
		return resultString;
	}
	
	public String inputString(String msg, String regex) {
        String resultStr;
        do {
               System.out.print(msg);
               resultStr = input.nextLine();
        } while (resultStr.length() == 0 || !validator.validatePattern(resultStr, regex));
        return resultStr;
   }

}
