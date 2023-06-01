package Common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public boolean validatePattern(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public String normalizeName(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        String[] nameParts = name.trim().split("\\s+");
        StringBuilder normalized = new StringBuilder();

        for (String part : nameParts) {
            String normalizedPart = Character.toUpperCase(part.charAt(0)) + part.substring(1).toLowerCase();
            normalized.append(normalizedPart).append(" ");
        }

        return normalized.toString().trim();
    }
}
