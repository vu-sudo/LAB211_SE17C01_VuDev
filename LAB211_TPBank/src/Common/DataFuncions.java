package Common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Model.Translator;
import Model.User;

public class DataFuncions {

    private Translator translator = new Translator();

    public void readDataFromFile(String fName, ArrayList<User> userList) {
        File file = new File(fName);
        if(!file.exists()) {
            throw new RuntimeException(translator.translate("This_file_isn't_exist"));
        }
        String line = "";
        try {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fName)))){
                while ((line = bufferedReader.readLine()) != null) {
                    String[] lStrings = line.split(" - ");
                    if(lStrings.length > 0) userList.add(new User(lStrings[0], lStrings[1]));
                }
            }
        } catch (Exception e) {
            // System.out.println("Load file failed!");
            System.out.println(e.getMessage());
        }
        // System.out.println("LOAD FILE SUCESSFULLY!");
    }

    public void saveDataToFile(String path , ArrayList<User> userList) {
        try {
            FileWriter wf = new FileWriter(path);
            for (User user: userList) {
                wf.write(user + System.lineSeparator());
            }
            wf.close();
            // System.out.println("SUCESSFULLY WROTE TO THE FILE!");
        } catch (IOException e) {
            System.out.println(translator.translate("AN_ERROR_OCCURED"));
            e.printStackTrace();
        }
    }

    public void saveDataToFileAppend(String path, User user) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(user.toString());
            writer.newLine();
        } catch(IOException e) {
            System.out.println(translator.translate("AN_ERROR_OCCURED"));
            e.printStackTrace();
        }
    }
}
