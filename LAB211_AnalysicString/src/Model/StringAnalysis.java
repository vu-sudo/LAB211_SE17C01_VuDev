package Model;

import java.util.ArrayList;

public class StringAnalysis {
    private String stringAnalysis;

    public String getStringLine() {
        return stringAnalysis;
    }

    public void setStringLine(String stringLine) {
        this.stringAnalysis = stringLine;
    }
    
    public Integer numberOfCharacters() {
        return stringAnalysis.length();
    }

    public String takeAllCharacters() {
        StringBuilder allChars = new StringBuilder();
        for(char c: stringAnalysis.toCharArray()) {
            if(!Character.isDigit(c)) {
                allChars.append(c);
            }
        }
        return allChars.toString();
    }

    public String extractUpperCaseChars() {
        return stringAnalysis.replaceAll("[^A-Z]", "");
    }
    public String extractLowerCaseChars() {
        return stringAnalysis.replaceAll("[^a-z]", "");
    }
    public String extractSpecialChar() {
        return stringAnalysis.replaceAll("[\\w\\s]", "");
    }
    
    public ArrayList<Integer> extractNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();
        for(char c: stringAnalysis.toCharArray()) {
            if(Character.isDigit(c)) {
                currentNumber.append(c);
            } else if(currentNumber.length() > 0) {
                numbers.add(Integer.parseInt(currentNumber.toString()));
                currentNumber.setLength(0);
            }
        }
        if (currentNumber.length() > 0) {
            numbers.add(Integer.parseInt(currentNumber.toString()));
        }
        return numbers;
    }
    public ArrayList<Integer> extractEvenNumbers() {
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> numbers = extractNumbers();
        for(Integer num : numbers) {
            if(num %2 == 0) {
                evenNumbers.add(num);
            }
        }   
        return evenNumbers;
    }
    public ArrayList<Integer> extractOddNumbers() {
        ArrayList<Integer> numbers = extractNumbers();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        for(Integer num : numbers) {
            if(num %2 != 0) {
                oddNumbers.add(num);
            }
        }   
        return oddNumbers;
    }
    public ArrayList<Integer> extractPerfectSquareNumbers() {
        ArrayList<Integer> numbers = extractNumbers();
        ArrayList<Integer> perfectSquareNumbers = new ArrayList<>();
        for (int num : numbers) {
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num) {
                perfectSquareNumbers.add(num);
            }
        }
        return perfectSquareNumbers;
    }
}
