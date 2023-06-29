package Controller;

import java.util.ArrayList;
import java.util.List;

import Common.FunctionsLibrary;
import Model.Expense;

public class ExpensesController {
    private final FunctionsLibrary functionsLibrary = new FunctionsLibrary();
    private List<Expense> expensesList = new ArrayList<>();
    private Expense toReset = new Expense();

    public void handleAddExpenses() {
        functionsLibrary.useLoadDataFromFile(expensesList);
        // toReset.resetIdCounter(expensesList);
        functionsLibrary.addExpense(expensesList);
        functionsLibrary.useSaveDataToFile(expensesList);
        expensesList.clear();
    }

    public void handleDisplayExpenses() {
        toReset.resetIdCounter(expensesList);
        functionsLibrary.useLoadDataFromFile(expensesList);
        functionsLibrary.displayAllExpensesList(expensesList, "====================EXPENSES LIST====================");
        expensesList.clear();
    }

    public void handleRemoveExpenses() {
        functionsLibrary.useLoadDataFromFile(expensesList);
        toReset.resetIdCounter(expensesList);
        functionsLibrary.removeExpenseById(expensesList);
        expensesList.clear();
    }
}
