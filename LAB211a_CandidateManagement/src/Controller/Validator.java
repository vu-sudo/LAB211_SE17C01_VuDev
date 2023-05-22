package Controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Scanner input = new Scanner(System.in);
    public boolean validateDateOfBirth(String birthDate) {
        Pattern pattern = Pattern.compile("^19[0-9]{2}|20[0-2][0-9]$");
        Matcher matcher = pattern.matcher(birthDate);
        return matcher.matches();
    }

    public boolean validatePhoneNumber(String phone) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validateYearsOfExperience(String expInYear) {
        int years;
        try {
            years = Integer.parseInt(expInYear);
        } catch (NumberFormatException e) {
            return false;
        }
        return years >= 0 && years <= 100;
    }

    public boolean validateRankOfGraduation(String gradRank) {
        return gradRank.equalsIgnoreCase("Excellence") || gradRank.equalsIgnoreCase("Good") || gradRank.equalsIgnoreCase("Fair") || gradRank.equalsIgnoreCase("Poor");
    }

}
