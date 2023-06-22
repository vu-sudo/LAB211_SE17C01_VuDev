package Common;

import java.util.HashMap;
import java.util.Scanner;

public class InputLibrary {
    private Validation validator = new Validation();
    private static final Scanner input = new Scanner(System.in);

    public String search(String str, HashMap<String, String> dictionary) {
        str = str.trim().toLowerCase();
        if (dictionary.containsKey(str)) {
            return dictionary.get(str);
        }
        return null;
    }

    public boolean isDuplicatedKey(String str, HashMap<String, String> dictionary) {
        str = str.trim();
        return search(str, dictionary) != null;
    }

    public String inputStringValue(String msg, String regex) {
        String stringValue;
        do {
            System.out.print(msg);
            stringValue = input.nextLine().trim();
        } while (!validator.validatePattern(stringValue, regex) || stringValue.length() == 0 || stringValue == null);
        return stringValue;
    }

    public String searchByMeaning(String str, HashMap<String, String> dictionary) {
        str = str.trim().toLowerCase();
        for (String enString : dictionary.keySet()) {
            String viString = dictionary.get(enString);
            if (str.equals(viString)) {
                return enString;
            }
        }
        return null;
    }
}
