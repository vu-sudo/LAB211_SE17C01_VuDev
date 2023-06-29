package Common;

import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Model.Expense;

public class FunctionsLibrary {
    private final InputsLibrary inputsLibrary = new InputsLibrary();
    private final Scanner input = new Scanner(System.in);
    private final DataFunctionsLibrary dataFunctionsLibrary = new DataFunctionsLibrary();

    public void useLoadDataFromFile(List<Expense> expensesList) {
        String path = Paths.get("").toAbsolutePath().toString();
        dataFunctionsLibrary.readDataFromFile(path + "/src/Data/Expenses.txt", expensesList);
    }

    public void useSaveDataToFile(List<Expense> expensesList) {
        String path = Paths.get("").toAbsolutePath().toString();
        dataFunctionsLibrary.saveDataToFile(path + "/src/Data/Expenses.txt", expensesList);
    }

    public void addExpense(List<Expense> expensesList) {
        // useLoadDataFromFile(expensesList);
        String choice = "";
        do {
            Date date = inputsLibrary.inputDate("Enter date: ");
            Double amount = inputsLibrary.inputAmount("Enter amount: ");
            String content = inputsLibrary.inputContent("Enter content: ");
            Expense expense = new Expense(date, amount, content);
            expensesList.add(expense);
            choice = inputsLibrary.inputChoice("Do you want to continue? (Y|N|y|n|Yes|No|yes|no|YES|NO)").toUpperCase();
        } while (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES"));
        // useSaveDataToFile(expensesList);
        // expensesList.clear();
    }

    public void displayAllExpensesList(List<Expense> expensesList, String msg) {
        // useLoadDataFromFile(expensesList);
        if (expensesList.isEmpty()) {
            System.out.println("THE LIST IS EMPTY! PLEASE INPUT ELEMENTS TO DISPLAY!");
        } else {
            System.out.println("\n" + msg);
            System.out.println(
                    "\n-----------------------------------------------------------------");
            System.out.format("| %3s | %15s | %10s | %15s |", "ID", "DATE", "AMOUNT", "CONTENT");
            System.out.println(
                    "\n-----------------------------------------------------------------");
            for (Expense expense : expensesList) {
                System.out.format("| %3d | %15s | %10.1f | %15s |", expense.getId(),
                        expense.convertToString(expense.getDate()),
                        expense.getAmount(), expense.getContent());
                System.out.println(
                        "\n-----------------------------------------------------------------");
            }
        }
    }

    public Expense search(Integer id, List<Expense> expensesList) {
        for (Expense expense : expensesList) {
            if (expense.getId().equals(id)) {
                return expense;
            }
        }
        return null;
    }

    public void removeExpenseById(List<Expense> expensesList) {
        // useLoadDataFromFile(expensesList);
        boolean isCancelled = false;
        if (expensesList.isEmpty()) {
            System.out.println("THE LIST IS EMPTY! PLEASE INPUT ELEMENTS TO USE THIS FUNCTION!");
            isCancelled = true;
        } else {
            String status = "";
            do {
                Integer searchId;
                System.out.print("Enter id to remove: ");
                searchId = Integer.parseInt(input.nextLine());
                Expense resultExpense = search(searchId, expensesList);
                if (resultExpense == null) {
                    System.out.println("THERE IS NO EXPENSE WITH ID " + searchId);
                } else {
                    System.out.println("You are removing expense id " + searchId);
                    String choice = inputsLibrary
                            .inputChoice("Are you sure to delete this? (Y|N|y|n|Yes|No|yes|no|YES|NO)").toUpperCase();
                    if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES")) {
                        expensesList.remove(resultExpense);
                        for (int i = 0; i < expensesList.size(); i++) {
                            expensesList.get(i).setId(i + 1);
                        }
                        System.out.println("Remove successfuly!");
                        useSaveDataToFile(expensesList);
                    } else {
                        System.out.println("You have cancelled removing this expense!");
                    }
                    status = inputsLibrary.inputChoice("Do you want to continue removing? ").toUpperCase();

                }

            } while (status.equalsIgnoreCase("Y") || status.equalsIgnoreCase("YES"));
        }
        if (isCancelled == false) {
            displayAllExpensesList(expensesList, "===================EXPENSES LIST AFTER REMOVAL===================");
        }
        // useSaveDataToFile(expensesList);
        // expensesList.clear();
    }
}
