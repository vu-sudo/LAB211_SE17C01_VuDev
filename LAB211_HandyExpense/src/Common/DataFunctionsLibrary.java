package Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import Model.Expense;

public class DataFunctionsLibrary {
    public void readDataFromFile(String fName, List<Expense> expensesList) {
        File file = new File(fName);
        if (!file.exists()) {
            throw new RuntimeException("This file isn't exist!");
        }
        String line = "";
        try {
            try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fName)))) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] lStrings = line.split(";");
                    Expense expense = new Expense();
                    Date date = expense.convertToDate(lStrings[1]);
                    Double amount = Double.parseDouble(lStrings[2]);
                    String content = lStrings[3];
                    expensesList.add(new Expense(date, amount, content));
                }
            }
        } catch (Exception e) {
            // System.out.println("Load file failed!");
            System.out.println(e.getMessage());
        }
        // System.out.println("LOAD FILE SUCESSFULLY!");
    }

    public void saveDataToFile(String path, List<Expense> expensesList) {
        try {
            FileWriter wf = new FileWriter(path);
            for (Expense expense : expensesList) {
                wf.write(expense.getId() + ";" + expense.convertToString(expense.getDate()) + ";"
                        + expense.getAmount().toString() + ";" + expense.getContent()
                        + System.lineSeparator());
            }
            wf.close();
            // System.out.println("SUCESSFULLY WROTE TO THE FILE!");
        } catch (IOException e) {
            System.out.println("AN ERROR OCCORED!");
            e.printStackTrace();
        }
    }
}
