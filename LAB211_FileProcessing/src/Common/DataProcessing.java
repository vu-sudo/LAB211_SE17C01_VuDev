package Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Model.Person;

public class DataProcessing {
    
    public void loadDataFromFile(String fname, ArrayList<Person> personList) {
        File file = new File(fname);
        if (!file.exists()) {
            throw new RuntimeException("This file isn't exit!");
        }
        String line = "";
        try {
            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fname)))) {
                while((line = bufferedReader.readLine()) != null) {
                    String[] lStrings = line.split("; ");
                    personList.add(new Person(lStrings[0], lStrings[1], Double.parseDouble(lStrings[2])));
                }
            }
        } catch (Exception e ) {
            System.out.println("Load file faild!");
        }
        System.out.println("File is exist!");
    }

    public void saveDataToFile(String path, ArrayList<Person> personList) {
        try {
            FileWriter wf = new FileWriter(path);
            for (Person person: personList) {
                wf.write((person.getName() + "; " + person.getAddress() + "; " + person.getMoney()) + System.lineSeparator());
            }
            wf.close();
            System.out.println("COPY DONE...");
        } catch (IOException e) {
            System.out.println("AN ERROR OCCORED!");
            e.printStackTrace();
        }
    }

}
