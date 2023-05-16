package Common;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class InputValidates {
    private final Scanner input = new Scanner(System.in);

    public String setStringValue(String msg) {
        System.out.println(msg);
        return input.nextLine();
    }
    public String inputNonBlankStr (String msg, String pat) {
        String data = "";
        while (data.length() == 0 && !data.matches(pat)){
            try {
                System.out.print(msg);
                data = input.nextLine().trim();
            } catch (PatternSyntaxException e) {
                System.out.println("Input failed! pls try again!");
            }
        }
        return data;
    }
}
