package Controller;

import Common.ChangeBase;
import Common.InputValidates;
import Common.LetterCharacter;

import java.util.Map;

public class ProgramController {
    private String str;

    InputValidates validates = new InputValidates();
    LetterCharacter counter = new LetterCharacter();
    ChangeBase converter = new ChangeBase();

    public void setString() {
        this.str = validates.setStringValue("Enter you string to count!");
    }
    public void handleCounting() {
        setString();
        Map<String, Integer> wordFreq = counter.countWords(this.str);
        Map<Character, Integer> charFreq = counter.countChars(this.str);
        System.out.println("Word frequency: " + wordFreq);
        System.out.println("Character frequency: " + charFreq);
    }
    public void handleChangeBase() {
        int base = Integer.parseInt(validates.inputNonBlankStr("Enter the base (2, 10 or 16)", "\\b(2|10|16)\\b"));
        String numberString = validates.inputNonBlankStr("Enter the number!: ", "[0-9A-F]");
        int targetBase = Integer.parseInt(validates.inputNonBlankStr("Enter the target base (2, 10 or 16): ", "\\b(2|10|16)\\b"));
        Integer decimalNumber = converter.convertToDecimal(numberString, base);
        String targetNumberString = converter.convertFromDecimal(decimalNumber, targetBase);
        System.out.format("The number %s in base %d is %s in base %d\n", numberString, base, targetNumberString, targetBase);
    }
}
