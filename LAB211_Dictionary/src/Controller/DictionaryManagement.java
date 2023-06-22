package Controller;

import java.util.HashMap;

import Common.DictionaryFunctions;

public class DictionaryManagement {
    protected HashMap<String, String> dictionary = new HashMap<>();
    private DictionaryFunctions dictionaryFunctions = new DictionaryFunctions();

    public void handleAddNewWord() {
        dictionaryFunctions.addNewWord(dictionary);
    }

    public void handleRemoveWord() {
        dictionaryFunctions.removeDictionaryWord(dictionary);
    }

    public void handleTranslateWord() {
        dictionaryFunctions.translating(dictionary);
    }

}
