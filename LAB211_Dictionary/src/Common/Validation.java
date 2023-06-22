package Common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public boolean validatePattern(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}