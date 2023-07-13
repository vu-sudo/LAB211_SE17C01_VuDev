package Common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileProcessingFunctionsLibrary {

    public String checkPathExists(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isFile()) {
                return "-> Path to File.";
            } else if (file.isDirectory()) {
                return "-> Path to Directory.";
            }
        }
        return "-> Path does not exist.";
    }

    public String[] listJavaFiles(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".java"));
        if (files != null) {
            String[] javaFiles = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                javaFiles[i] = files[i].getName();
            }
            return javaFiles;
        }
        return new String[0];
    }

    public String[] findFilesBySize(String directoryPath, Integer sizeInKB) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        List<String> largeFiles = new ArrayList<>();
        
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.length() > sizeInKB * 1024) {
                    largeFiles.add(file.getName());
                }
            }
        }
        
        return largeFiles.toArray(new String[0]);
    }

    public  void appendContentToFile(String filePath, String content) {
        File file = new File(filePath);
        
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }
        
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int countWordsInFile(String filePath) {
        File file = new File(filePath);
        
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return 0;
        }
        try {
            String content = Files.readString(Path.of(filePath));
            String[] words = content.split("\\s+");
            return words.length;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void displayInfo(String[] datas) {
        if (datas.length == 0) {
            System.out.println("\n-> Result 0 file!");
            return;
        }
        System.out.println();
        for (String str: datas) {
            System.out.println("-> " + str);
        }
    }
}
