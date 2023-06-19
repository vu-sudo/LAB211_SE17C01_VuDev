package Common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public boolean validateInputPattern(String inputString, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);
        return matcher.matches();
    }
}
