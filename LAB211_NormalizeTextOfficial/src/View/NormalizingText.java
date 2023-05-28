package View;

import Controller.NormalizeService;

public class NormalizingText {
    NormalizeService normalizeService = new NormalizeService();

    void run() {
        normalizeService.handleLoadDataFromFile();
        normalizeService.handleNormalizeText();
        normalizeService.handleSaveDataToFile();
    }
    public static void main(String[] args) {
        NormalizingText normalizingText = new NormalizingText();
        normalizingText.run();
    }
}
