package Common;

import java.util.ArrayList;
import java.util.Scanner;

import Model.User;

public class InputLibrary {
    private Validation validator = new Validation();
    private static final Scanner input = new Scanner(System.in);

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
    public String inputUserName(String msg, ArrayList<User> userList) {
        boolean isDuplicated = false;
        String resultString;
        do {
            System.out.print(msg);
            resultString = input.nextLine().trim();
            isDuplicated = isDuplicatedUser(resultString, userList);
            if (isDuplicated) {
                System.out.println("The user name is duplicated! try another!");
            } else if (!validator.validatePattern(resultString, "^(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).+$")
                    || resultString.length() < 5) {
                System.out.println("You must enter least at 5 character, and no space, one character is upper!");
            }
        } while (isDuplicated == true || resultString.length() < 5
                || !validator.validatePattern(resultString, "^(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).+$"));
        return resultString;
    }

    // input password;
    public String inputPassWord(String msg) {
        String resultString;
        do {
            System.out.print(msg);
            resultString = input.nextLine().trim();
            if (resultString.length() < 6) {
                System.out.println("Invalid password! The password must be least at 6 character");
            } else if (!validator.validatePattern(resultString,
                    "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[.@#&$])(?!.*\\s).{6,}$")) {
                System.out.println("Invalid password! The password contain number, least at one specical character!");
            }
        } while (resultString.length() < 6 || !validator.validatePattern(resultString,
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[.@#&$])(?!.*\\s).{6,}$"));
        return resultString;
    }

    // input log user;
    public User inputLogUserName(String msg, ArrayList<User> userList) {
        String findString;
        User checkingUser = null;
        do {
            System.out.print(msg);
            findString = input.nextLine().trim();

            if (!validator.validatePattern(findString, "^(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).+$")
                    || findString.length() < 5) {
                System.out.println("You must enter least at 5 character, and no space, one character is upper!");
            } else {
                checkingUser = search(findString, userList);
            }

            if (checkingUser != null && checkingUser.getUserName().equals(findString)) {
                System.out.println("FOUND USER: " + checkingUser.getUserName());
            } else {
                System.out.println("The user: " + findString + " NOT FOUND!");
            }

        } while (findString.length() < 5
                || !validator.validatePattern(findString, "^(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).+$")
                || checkingUser == null);
        return checkingUser;
    };
}
