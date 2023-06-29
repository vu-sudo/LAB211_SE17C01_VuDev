package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
// import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
// import java.util.Locale;

public class Expense {
    private Integer id;
    private Date date;
    private Double amount;
    private String content;

    private static int nextId = 1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Expense(Date date, Double amount, String content) {
        super();
        this.id = nextId++;
        this.date = date;
        this.amount = amount;
        this.content = content;
    }

    public Expense() {
        super();
    }

    public String convertToString(Date date) {
        String dateString = null;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy");

        // Format the date to a string using the formatter
        dateString = dateFormatter.format(date);
        return dateString;
    }

    public Date convertToDate(String dateString) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy");

        try {
            this.date = dateFormatter.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        }
        return date;
    }

    public void resetIdCounter(List<Expense> expensesList) {
        // if (expensesList.isEmpty()) {
        //     nextId = 0;
        // } else {
        //     int minId = Integer.MAX_VALUE;
        //     for (Expense expense : expensesList) {
        //         if (expense.getId() < minId) {
        //             minId = expense.getId();
        //         }
        //     }
        //     nextId = minId;
        // }
        nextId = 1;
    }

}