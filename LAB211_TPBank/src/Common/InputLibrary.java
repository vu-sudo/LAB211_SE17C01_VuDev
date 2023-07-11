package Common;

import java.util.ArrayList;
import java.util.Scanner;
import Model.Translator;
import Model.User;

public class InputLibrary {
    private Validation validator = new Validation();
    private static final Scanner input = new Scanner(System.in);
    private Translator translator = new Translator();

    public User search(String string, ArrayList<User> userList) {
        string = string.trim();
        for (User user : userList) {
            if (user.getUserName().equals(string)) {
                return user;
            }
        }
        return null;
    }

    public boolean isDuplicatedUser(String string, ArrayList<User> userList) {
        string = string.trim();
        return search(string, userList) != null;
    }

    // input userName;
    public String inputAccountNumber(String msg, ArrayList<User> userList) {
        boolean isDuplicated = false;
        String resultString;
        do {
            System.out.print(msg);
            resultString = input.nextLine().trim();
            isDuplicated = isDuplicatedUser(resultString, userList);
            if (isDuplicated) {
                // System.out.println("The user name is duplicated! try another!");
                System.out.println(translator.translate("The_account_number_is_duplicated_Try_another"));

            } else if (!validator.validatePattern(resultString, "\\d{10}")
                    || resultString.length() != 10) {
                System.out.println(translator.translate("Account_number_must_is_a_number_and_must_have_10_digits"));
            }
        } while (isDuplicated == true || resultString.length() != 10
                || !validator.validatePattern(resultString, "\\d{10}"));
        return resultString;
    }

    // input password;
    public String inputPassWord(String msg) {
        String resultString;
        do {
            System.out.print(msg);
            resultString = input.nextLine().trim();
            if (resultString.length() < 8 || resultString.length() > 31) {
                System.out.println(translator.translate("Password_must_be_between_8_and_31_characters"));
            } else if (!validator.validatePattern(resultString,
                    "^(?=.*[0-9])(?=.*[a-zA-Z]).+$")) {
                System.out.println(translator.translate("Password_must_be_between_8_and_31_characters_and_must_be_alphanumeric"));
            }
        } while (resultString.length() < 8 || resultString.length() > 31 || !validator.validatePattern(resultString,
                "^(?=.*[0-9])(?=.*[a-zA-Z]).+$"));
        return resultString;
    }

    // input log user;
    public User inputLogAccount(String msg, ArrayList<User> userList) {
        String findString;
        User checkingUser = null;
        do {
            System.out.print(msg);
            findString = input.nextLine().trim();

            if (!validator.validatePattern(findString, "\\d{10}")
                    || findString.length() < 5) {
                System.out.println(translator.translate("Account_number_must_is_a_number_and_must_have_10_digits"));
            } else {
                checkingUser = search(findString, userList);
            }

            if (checkingUser != null && checkingUser.getUserName().equals(findString)) {
                System.out.println(translator.translate("FOUND_USER") + checkingUser.getUserName());
            } else {
                System.out.println(translator.translate("The_user") + findString + translator.translate("NOT_FOUND"));
            }

        } while (findString.length() < 5
                || !validator.validatePattern(findString, "\\d{10}")
                || checkingUser == null);
        return checkingUser;
    };

    public String inputString(String msg) {
        String resultString;
        do {
            System.out.print(msg);
            resultString = input.nextLine().trim();
        } while (resultString.length() == 0);
        return resultString;
    }
}
