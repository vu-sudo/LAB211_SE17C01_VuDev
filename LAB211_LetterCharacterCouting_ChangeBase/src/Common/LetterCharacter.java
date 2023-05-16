package Common;


import java.util.*;

public class LetterCharacter {
    public Map<String, Integer> countWords(String inputString) {
        String[] words = inputString.trim().split("\\s+");
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            if (wordFreq.containsKey(word)) {
                wordFreq.put(word, wordFreq.get(word) + 1);
            } else {
                wordFreq.put(word, 1);
            }
        }
        return wordFreq;
    }

    public Map<Character, Integer> countChars(String inputString) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (charFreq.containsKey(c)) {
                charFreq.put(c, charFreq.get(c) + 1);
            } else {
                charFreq.put(c, 1);
            }
        }
        return charFreq;
    }
}
