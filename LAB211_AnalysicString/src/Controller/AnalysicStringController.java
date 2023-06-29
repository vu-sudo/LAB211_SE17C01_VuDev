package Controller;

import Model.AnalyzedData;
import Model.StringAnalysis;

public class AnalysicStringController {
    private final AnalyzedData analyzedData = new AnalyzedData();
    private final StringAnalysis stringAnalysis = new StringAnalysis();
    private final InputLibrary inputLibrary = new InputLibrary();

    public void inputString() {
        stringAnalysis.setStringLine(inputLibrary.setStringValue("Input String: "));
    }
    public void handleAnalyzeData() {
        if(stringAnalysis.getStringLine().length() <= 0) {
            System.out.println("The analyzed string is empty!");
        } else {
            analyzedData.setNumberOfCharacters(stringAnalysis.numberOfCharacters());
            analyzedData.setPerfectSquareNumbers(stringAnalysis.extractPerfectSquareNumbers());
            analyzedData.setOddNumbers(stringAnalysis.extractOddNumbers());
            analyzedData.setEvenNumbers(stringAnalysis.extractEvenNumbers());
            analyzedData.setAllNumber(stringAnalysis.extractNumbers());
            analyzedData.setLowercaseChar(stringAnalysis.extractLowerCaseChars());
            analyzedData.setUppercaseChar(stringAnalysis.extractUpperCaseChars());
            analyzedData.setSpecialChar(stringAnalysis.extractSpecialChar()); 
            analyzedData.setAllCharaters(stringAnalysis.takeAllCharacters());
        }
    }
    public void handleShowData() {
        System.out.println(analyzedData);
    }
}
