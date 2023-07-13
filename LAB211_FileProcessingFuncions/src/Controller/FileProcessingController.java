package Controller;

import Common.FileProcessingFunctionsLibrary;
import Common.InputLibrary;

public class FileProcessingController {
    private InputLibrary inputLibrary = new InputLibrary();
    private FileProcessingFunctionsLibrary fileProcessing = new FileProcessingFunctionsLibrary();

    public void handleCheckingFileExist() {
        System.out.println("\n---Checking Path---");
        String  path = inputLibrary.setStringValue("Enter path: ");
        System.out.println(fileProcessing.checkPathExists(path));  
    }

    public void handleGetFileJava() {
        System.out.println("\n---Get file name with type java---");
        String path = inputLibrary.setStringValue("Enter directory path: ");
        String[] resultDatas = fileProcessing.listJavaFiles(path);
        fileProcessing.displayInfo(resultDatas);
    }

    public void handleGetFileSizeGreaterThanInput() {
        System.out.println("---Get file with size greater than input---");
        String path = inputLibrary.setStringValue("Enter directory path: ");
        Integer fileSize = inputLibrary.setIntegerValue("Enter file size (KB) : ");
        String[] resultData = fileProcessing.findFilesBySize(path, fileSize);
        fileProcessing.displayInfo(resultData);
    }

    public void handleAppendContentToFile() {
        System.out.println("---Write more content to file---");
        String content = inputLibrary.setStringValue("Enter content: " );
        String path = inputLibrary.setStringValue("Enter file path: ");
        fileProcessing.appendContentToFile(path, content);

    }

    public void handleCountWordsInFile() {
        System.out.println("---Read file an count characters---");
        String path = inputLibrary.setStringValue("Enter file path: ");
        System.out.println("\n-> Total of words: " + fileProcessing.countWordsInFile(path));
    }
}
