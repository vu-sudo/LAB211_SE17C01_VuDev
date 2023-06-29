package Common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputsLibrary {
    private final Validation validator = new Validation();
    private final Scanner input = new Scanner(System.in);

    public String inputPhoneNumber() {
        String phoneNumberString = "";
        Long phoneNumber = (long) 0;
        boolean passed = false;
        do {
            try {
                System.out.print("Enter phone number: ");
                phoneNumberString = input.nextLine().trim();
                passed = true;
                if (phoneNumberString.length() != 10) {
                    System.out.println("Phone number must have 10 digits!");
                    passed = false;
                }
                phoneNumber = Long.parseLong(phoneNumberString);
            } catch (NumberFormatException e) {
                System.out.println("Phone must be a number!");
            }
        } while (passed == false || phoneNumberString.length() == 0 || phoneNumberString == null);
        return phoneNumberString;
    }

    public String inputEmail() {
        String emailString = "";
        do {
            System.out.print("Enter email: ");
            emailString = input.nextLine().trim();
            if (!validator.validatePattern(emailString,
                    "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$") || emailString == null
                    || emailString.length() == 0) {
                System.out.println("Email must be correct format");
            }
        } while (!validator.validatePattern(emailString,
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$") || emailString == null
                || emailString.length() == 0);
        return emailString;
    }

    public String inputDate() {
        Date resultDate = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        boolean passed = false;
        do {
            System.out.print("Enter date: ");
            // String dateFormatPattern = "dd-MMM-yyyy";
            try {
                // resultDate = LocalDate.parse(input.nextLine().trim(), dateFormatter);
                resultDate = dateFormatter.parse(input.nextLine().trim());
                passed = true;
            } catch (ParseException e) {
                System.out.println("Please input date in format <dd/MM/yyyy>!");
                passed = false;
            }
        } while (resultDate == null || passed == false);
        return dateFormatter.format(resultDate);
    }

}
