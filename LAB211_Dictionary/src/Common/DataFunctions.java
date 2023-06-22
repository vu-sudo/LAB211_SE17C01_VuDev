package Common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

public class DataFunctions {
    public void loadDataFromFile(String path, HashMap<String, String> dictionary) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // split by the delimiter
                    String[] parts = line.split(";");
                    // check if there are exactly two parts
                    if (parts.length == 2) {
                        // get the key and value
                        String enString = parts[0];
                        String viString = parts[1];
                        // put them into the hashmap
                        dictionary.put(enString, viString);
                    } else {
                        throw new IllegalArgumentException("Invalid line format");
                    }
                }
                br.close();
            }
        } catch (IOException e) {
            System.out.println("AN ERROR OCCURED!");
            e.printStackTrace();
        }
    }

    public void saveDataToFile(HashMap<String, String> dictionary) {
        try {
            String path = Paths.get("").toAbsolutePath().toString();
            try (FileWriter wf = new FileWriter(path + "/src/Data/dictionary.txt")) {
                for (String enString : dictionary.keySet()) {
                    String viString = dictionary.get(enString);
                    // check if key or value contains semicolon or newline
                    if (enString.contains(";") || enString.contains("\n") || viString.contains(";")
                            || viString.contains("\n")) {
                        throw new IllegalArgumentException("Key or value contains invalid characters");
                    }
                    wf.write(enString + ";" + viString + System.lineSeparator());
                }
                wf.close();
            }
        } catch (IOException e) {
            System.out.println("AN ERROR OCCURED!");
            e.printStackTrace();
        }
    }

    public void saveDataToFileAppend(String path, String enString, String viString) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter((path), true))) {
            writer.write(enString + ";" + viString);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("AN ERROR OCCURED!");
            e.printStackTrace();
        }
    }

}
