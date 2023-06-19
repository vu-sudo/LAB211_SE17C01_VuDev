package View;

import Controller.FileProcessingController;

public class FileProcessing extends Menu {
    private FileProcessingController fileProcessingController = new FileProcessingController();

    static String[] options = {
        "Find person information",
        "Copy Text to new file"
    };

    public FileProcessing() {
        super("FILE PROCESSING", options);
    }

    @Override
    public void execute(int number) {
        switch(number) {
            case 1:
                fileProcessingController.handleLoadDataFromFile();
                break;
            case 2:
                fileProcessingController.handleSaveDataToFile();
                break;
            case 3:
                System.out.println("Exited Program!");
            default: 
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        FileProcessing exe = new FileProcessing();
        exe.run();
    }
    
}
