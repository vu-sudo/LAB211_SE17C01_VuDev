package View;

import Controller.FileProcessingController;

public class FileProcessingView extends Menu {
    FileProcessingController fileProcessingController = new FileProcessingController();

    static String[] options = {
        "Check Path",
        "Get file name with type java",
        "Get file witt size greater than input",
        "Write more content to file",
        "Read file and count characters",
        "Exit"
    };

    public FileProcessingView() {
        super("FILE PROCESSING SYSTEM", options);
    }

    @Override
    public void execute(int number) {
        switch(number) {
            case 1:
                fileProcessingController.handleCheckingFileExist();
                waitToPressKey();
                break;
            case 2:
                fileProcessingController.handleGetFileJava();
                waitToPressKey();
                break;
            case 3:
                fileProcessingController.handleGetFileSizeGreaterThanInput();
                waitToPressKey();
                break;
            case 4:
                fileProcessingController.handleAppendContentToFile();
                waitToPressKey();
                break;
            case 5:
                fileProcessingController.handleCountWordsInFile();
                waitToPressKey();
                break;
            default:
                System.exit(0);
        }
    }
    
}
