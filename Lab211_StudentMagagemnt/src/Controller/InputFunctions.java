package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Student;

public class InputFunctions {
   private Validation validator = new Validation(); 
   private static final Scanner input = new Scanner(System.in);

   public String inputId(String msg, ArrayList<Student> studentsList) {
        boolean codeDuplicated = false;
        String resultString;
        do {
            System.out.print(msg);
            resultString = input.nextLine().trim().toUpperCase();
            codeDuplicated = validator.isDuplicated(resultString, studentsList);
            if (codeDuplicated) {
				System.out.println("ID is duplicated");
			}
        } while (codeDuplicated == true || resultString.length() == 0 || !validator.validatePattern(resultString, "^[dD]\\d+$"));

        return resultString;
   }

   public String inputName(String msg) {
        String resultString;
        do {
            System.out.print(msg);
            resultString = input.nextLine().trim();
        } while(!validator.validatePattern(resultString, "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$"));
        return resultString;
   }

   public Integer inputSesmeseter(String msg) {
        Integer resultInt = 0;
        do {
            try {
                System.out.print(msg);
                resultInt = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Must be a number!");
            }
        } while (resultInt == 0 || !validator.validatePattern(resultInt.toString(), "[0-9]"));
        return resultInt;
   }

   public String inputCourse(String msg) {
        String resultString;
        do {
            System.out.print(msg);
            resultString = input.nextLine();
        } while(!validator.validatePattern(resultString, "^(Java|\\.Net|C\\/C\\+\\+)$"));
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

   public String inputString(String msg, String regex) {
        String resultStr;
        do {
               System.out.print(msg);
               resultStr = input.nextLine();
        } while (resultStr.length() == 0 || !validator.validatePattern(resultStr, regex));
        return resultStr;
   }
}
