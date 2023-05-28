package Controller;

import java.nio.file.Paths;

import Common.NormalizeLibrary;

public class NormalizeService {
    NormalizeLibrary library = new NormalizeLibrary();
    String paragraph = "";

    public void handleLoadDataFromFile() {
        String path = Paths.get("").toAbsolutePath().toString();
        paragraph = library.readFromFile(path + "/src/Data/Input.txt");
        System.out.println("DATA LOADED FROM FILE: ");
        System.out.println(paragraph);
    }
    public void handleSaveDataToFile() {
        library.saveDataToFile(paragraph);
    }
    public void handleNormalizeText() {
        System.out.println("DATA AFTER NORMALIZED: ");
        paragraph = library.normalizeParagraph(paragraph);
        System.out.println(paragraph);
    }
}
