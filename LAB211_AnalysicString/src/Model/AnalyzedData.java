package Model;

import java.util.ArrayList;

public class AnalyzedData {
    private Integer numberOfCharacters;
    private ArrayList<Integer> perfectSquareNumbers;
    private ArrayList<Integer> oddNumbers;
    private ArrayList<Integer> evenNumbers;
    private ArrayList<Integer> allNumber;
    private String uppercaseChar;
    private String lowercaseChar;
    private String specialChar;
    private String allCharaters;
    
    public Integer getNumberOfCharacters() {
        return numberOfCharacters;
    }
    public ArrayList<Integer> getPerfectSquareNumbers() {
        return perfectSquareNumbers;
    }
    public ArrayList<Integer> getOddNumbers() {
        return oddNumbers;
    }
    public ArrayList<Integer> getEvenNumbers() {
        return evenNumbers;
    }
    public ArrayList<Integer> getAllNumber() {
        return allNumber;
    }
    public String getUppercaseChar() {
        return uppercaseChar;
    }
    public String getLowercaseChar() {
        return lowercaseChar;
    }
    public String getSpecialChar() {
        return specialChar;
    }
    public String getAllCharaters() {
        return allCharaters;
    }

    public void setNumberOfCharacters(Integer numberOfCharacters) {
        this.numberOfCharacters = numberOfCharacters;
    }
    public void setPerfectSquareNumbers(ArrayList<Integer> perfectSquareNumbers) {
        this.perfectSquareNumbers = perfectSquareNumbers;
    }
    public void setPerfectSquareNumbers(Integer perfectSquareNumbers) {
        this.perfectSquareNumbers.add(perfectSquareNumbers);
    }

    public void setOddNumbers(ArrayList<Integer> oddNumbers) {
        this.oddNumbers = oddNumbers;
    }
    public void setOddNumbers(Integer oddNumbers) {
        this.oddNumbers.add(oddNumbers);
    }
    public void setEvenNumbers(ArrayList<Integer> evenNumbers) {
        this.evenNumbers = evenNumbers;
    } 
    public void setEvenNumbers(Integer evenNumbers) {
        this.evenNumbers.add(evenNumbers);
    }
    public void setAllNumber(ArrayList<Integer> allNumber) {
        this.allNumber = allNumber;
    }
    public void setAllNumber(Integer allNumber) {
        this.allNumber.add(allNumber);
    }
    public void setUppercaseChar(String uppercaseChar) {
        this.uppercaseChar = uppercaseChar;
    }
    public void setLowercaseChar(String lowercaseChar) {
        this.lowercaseChar = lowercaseChar;     
    }
    public void setSpecialChar(String specialChar) {
        this.specialChar = specialChar;
    }
    public void setAllCharaters(String allCharaters) {
        this.allCharaters = allCharaters;
    }

    public AnalyzedData() {
        super();
        perfectSquareNumbers = new ArrayList<>();
        oddNumbers = new ArrayList<Integer>();
        evenNumbers = new ArrayList<Integer>();
        allNumber = new ArrayList<Integer>();
    }
    @Override
    public String toString() {
        return "Perfect square number: " + this.perfectSquareNumbers + "\n" 
        + "Odd number: " + this.oddNumbers + "\n" 
        + "Even number: " + this.evenNumbers + "\n"
        + "All number: " + this.allNumber + "\n"
        + "Uppercase Characters: " + this.uppercaseChar + "\n"
        + "Lowercase Characters: " + this.lowercaseChar + "\n"
        + "Special Characters: " +  this.specialChar + "\n"
        + "All Characters: " + this.allCharaters;
    } 
    
}
