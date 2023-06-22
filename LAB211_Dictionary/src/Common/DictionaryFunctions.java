package Common;

import java.nio.file.Paths;
import java.util.HashMap;

import View.Menu;

public class DictionaryFunctions {
    DataFunctions dataFunctions = new DataFunctions();
    InputLibrary inputLibrary = new InputLibrary();
    boolean isLoaded = false;

    public void useLoadDataFromFile(HashMap<String, String> dictionary) {
        String path = Paths.get("").toAbsolutePath().toString();
        dataFunctions.loadDataFromFile(path + "/src/Data/dictionary.txt", dictionary);
    }

    public void useSaveDateToFile(HashMap<String, String> dictionary) {
        dataFunctions.saveDataToFile(dictionary);
    }

    public void addNewWord(HashMap<String, String> dictionary) {
        useLoadDataFromFile(dictionary);
        isLoaded = true;
        String choice = "";
        do {
            String enString = inputLibrary.inputStringValue("Enter English word: ",
                    "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$").toLowerCase();
            if (dictionary.containsKey(enString)) {
                System.out.println(enString + " has already existed! You will have to update the Vietnamese meaning!");
                String viString = inputLibrary.inputStringValue("Enter new meaning: ",
                        "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$").toLowerCase();
                dictionary.replace(enString, viString);
            } else {
                String viString = inputLibrary.inputStringValue("Enter Vietnamese meaning: ",
                        "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$").toLowerCase();
                dictionary.put(enString, viString);
            }
            choice = inputLibrary
                    .inputStringValue("Do you want to add more word? (yY-YES or nN-NO)", "^(Y|y|N|n|YES|yes|NO|no)$")
                    .toUpperCase();
        } while (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES"));
        dataFunctions.saveDataToFile(dictionary);
        if (isLoaded == true)
            displayDictionary(dictionary, "==============Dictionary=============");
        dictionary.clear();
    }

    public void displayDictionary(HashMap<String, String> dictionary, String msg) {
        useLoadDataFromFile(dictionary);
        if (dictionary.isEmpty()) {
            System.out.println("DICTIONARY IS EMPTY! CANNOT DISPLAY!");
        } else {
            System.out.println("\n" + msg);
            System.out.println(
                    "\n-------------------------------------");
            System.out.format("| %15s | %15s |", "ENGLISH", "TIENG VIET");
            System.out.println(
                    "\n-------------------------------------");
            for (String enString : dictionary.keySet()) {
                String viString = dictionary.get(enString);
                System.out.format("| %15s | %15s |", enString, viString);
                System.out.println(
                        "\n-------------------------------------");
            }
        }
        dictionary.clear();
    }

    public void removeDictionaryWord(HashMap<String, String> dictionary) {
        useLoadDataFromFile(dictionary);
        isLoaded = true;
        String enSearchString = null;
        String resulString = null;
        if (dictionary.isEmpty()) {
            System.out.println("DICTIONARY IS EMPTY! CANNOT EXECUTE THIS FUNCTION!");
            isLoaded = false;
        } else {
            enSearchString = inputLibrary.inputStringValue("Enter English word you want to remove: ",
                    "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$").toLowerCase();
            resulString = inputLibrary.search(enSearchString, dictionary);
            if (resulString == null) {
                System.out.println("The word " + enSearchString + " doesn't exist in our dictionary!");
            } else {
                dictionary.remove(enSearchString, resulString);
                useSaveDateToFile(dictionary);
            }
        }
        if (isLoaded == true)
            displayDictionary(dictionary, "=========Dictionary========");
        dictionary.clear();
    }

    public void searchMeaning(HashMap<String, String> dictionary) {
        useLoadDataFromFile(dictionary);
        String enSearchString = null;
        String resulString = null;
        if (dictionary.isEmpty()) {
            System.out.println("DICTIONARY IS EMPTY! CANNOT EXECUTE THIS FUNCTION!");
        } else {
            enSearchString = inputLibrary.inputStringValue("Enter English word you want to find meaning: ",
                    "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$").toLowerCase();
            resulString = inputLibrary.search(enSearchString, dictionary);
            if (resulString == null) {
                System.out.println("The word " + enSearchString + " doesn't exist in our dictionary!");
            } else {
                System.out.println(enSearchString + " -> meaning: " + resulString);
            }
        }
        dictionary.clear();
    }

    public void searchByMeaning(HashMap<String, String> dictionary) {
        useLoadDataFromFile(dictionary);
        String viSearchString = null;
        String resultString = null;
        if (dictionary.isEmpty()) {
            System.out.println("DICTIONARY IS EMPTY! CANNOT EXECUTE THIS FUNCTION!");
        } else {
            viSearchString = inputLibrary.inputStringValue("Enter Vietnamese word you want to find meaning: ",
                    "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$").toLowerCase();
            resultString = inputLibrary.searchByMeaning(viSearchString, dictionary);
            if (resultString == null) {
                System.out.println("The word " + viSearchString + " doesn't exist in our dictionary!");
            } else {
                System.out.println(viSearchString + " -> meaning: " + resultString);
            }
        }
        dictionary.clear();

    }

    public void translating(HashMap<String, String> dictionary) {
        String[] options = {
                "Translate Eng -> Viet.",
                "Translate Viet -> Eng."
        };
        Menu eMenu = new Menu("CHOOSE OPTION YOU NEED!", options) {
            @Override
            public void execute(int number) {
                switch (number) {
                    case 1:
                        searchMeaning(dictionary);
                        break;
                    case 2:
                        searchByMeaning(dictionary);
                        break;
                    default:
                        System.out.println("Backed to main menu!");
                        return;
                }
            }
        };
        eMenu.run();
    }
}
