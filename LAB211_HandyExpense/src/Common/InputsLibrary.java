package Common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputsLibrary {
    private Validation validator = new Validation();
    private final Scanner input = new Scanner(System.in);

    public String inputContent(String msg) {
        String resultContent = "";
        do {
            System.out.print(msg);
            resultContent = input.nextLine().trim();
            resultContent = resultContent.substring(0, 1).toUpperCase() + resultContent.substring(1);
        } while (!validator.validatePattern(resultContent, "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$")
                || resultContent.length() == 0 || resultContent == null);
        return resultContent;
    }

    public Date inputDate(String msg) {
        Date resultDate = new Date();
        boolean passed = false;
        do {
            System.out.print(msg);
            // String dateFormatPattern = "dd-MMM-yyyy";
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy");
            try {
                // resultDate = LocalDate.parse(input.nextLine().trim(), dateFormatter);
                resultDate = dateFormatter.parse(input.nextLine().trim());
                passed = true;
            } catch (ParseException e) {
                System.out.println("Please input date in format <dd-MMM-yyyy>!");
                passed = false;
            }
        } while (resultDate == null || passed == false);
        return resultDate;
    }

    public Double inputAmount(String msg) {
        Double resultDouble = (double) 0;
        boolean passed = false;
        do {
            try {
                System.out.print(msg);
                resultDouble = Double.parseDouble(input.nextLine().trim());
                passed = true;
                if (resultDouble <= 0) {
                    System.out.println("Amount must be greater than 0! Please input again!");
                    passed = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        } while (passed = false || resultDouble <= (double) 0);
        return resultDouble;
    }

    public String inputChoice(String msg) {
        String resultChoice = "";
        do {
            System.out.print(msg);
            resultChoice = input.nextLine().trim();
        } while (!validator.validatePattern(resultChoice, "^(Y|y|N|n|YES|yes|NO|no)$") || resultChoice.length() == 0);
        return resultChoice;
    }
}
