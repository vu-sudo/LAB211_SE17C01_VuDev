package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Customer;
import Model.Fruit;
import Model.FruitOrdered;

public class ShopManagementFunctions {
    InputFunctions inputFunctions = new InputFunctions();
    Validation validator = new Validation();
    private boolean isLoadFile = false;
    private static final Scanner input = new Scanner(System.in);

    public void waitForPressAnyKey() {
        System.out.println("Press any key to continue...");
        input.nextLine();
    }

    public void loadData(String fname, ArrayList<Fruit> fruitsList) {
        File file = new File(fname);
        if (!file.exists())
            throw new RuntimeException("File is not exist!");
        String line = "";
        try {
            try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fname)))) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] lStrings = line.split("-");
                    fruitsList.add(new Fruit(lStrings[0], lStrings[1], Integer.parseInt(lStrings[2]), Integer.parseInt(lStrings[3]), lStrings[4]));
                }
            }
        } catch (Exception e) {
            System.err.println("Load file error!");
        }
        System.out.println("LOAD FILE SUCESSFUALLY!");
    }
    public void loadDataFromFile(ArrayList<Fruit> fruitsList) {
        if(isLoadFile) {
            System.out.println("FILE IS LOADED! CANT LOAD AGAIN!");
        } else {
            String path = Paths.get("").toAbsolutePath().toString();
            loadData(path + "/src/Data/FruitList.txt", fruitsList);
            isLoadFile = true;
            displayFruitList(fruitsList, "LIST OF FRUIT");
        }
    }
    public void addNewFruit(ArrayList<Fruit> fruitsList) {
        String fruitId  = inputFunctions.inputIdValue("Enter Fruit ID (format: F<number>): ", fruitsList, "^[fF]\\d+$");
        String fruitName = inputFunctions.inputStringValue("Enter Fruit Name: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$");
        Integer fruitPrice = inputFunctions.inputNumberValue("Enter Price of " + fruitName +": ", "^(?:100|[1-9][0-9]?|0)$");
        Integer fruitQuantity = inputFunctions.inputNumberValue("Enter Quantity of " + fruitName + ": ", "^(?:1000|[1-9][0-9]{0,2}|0)$");
        String fruitOrigin = inputFunctions.inputStringValue("Enter the Origin of " + fruitName + ": ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$");
        Fruit fruit = new Fruit(fruitId, fruitName, fruitPrice, fruitQuantity, fruitOrigin);
        fruitsList.add(fruit);
    }
    public void addFruitToList(ArrayList<Fruit> fruitsList) {
        String option;
        do {
            addNewFruit(fruitsList);
            System.out.println("Do you want to continue (Y/N)?");
            option = inputFunctions.inputStringValue("Enter Y-YES | N-NO: ", "^(Y|y|N|n|YES|yes|NO|no)$").toUpperCase();
        } while (option.equalsIgnoreCase("Y"));
        displayFruitList(fruitsList, "YOUR LIST OF FRUIT: ");
    }
    public void displayFruitList(ArrayList<Fruit> fruitsList, String msg) {
        if(fruitsList.isEmpty()) {
            System.out.println("FRUIT LIST IS EMPTY! HAVE NOTHING TO SHOW!");
        } else {
            System.out.println("\n" + msg);
            System.out.println("---------------------------------------------------------------------------");
            System.out.format("| %5s | %18s | %18s | %8s | %10s |\n", "ITEMS", "FRUIT NAME", "ORIGIN", "PRICE", "QUANTITY");
            System.out.println("---------------------------------------------------------------------------");
            for(Fruit fruit : fruitsList) {
                System.out.format("| %5s | %18s | %18s | %8s | %10s |\n", fruit.getFruitId(), fruit.getFruitName(), fruit.getFruitOrigin(), fruit.getFruitPrice()+"$", fruit.getFruitQuantity());
                System.out.println("---------------------------------------------------------------------------");
            }
        }
    }
    public void orderFruit(ArrayList<Fruit> fruitsList, ArrayList<Customer> customersList) {
        if(fruitsList.isEmpty()) {
            System.out.println("FRUIT LIST IS EMPLTY! LET'S CREATE SOME FRUIT TO LIST!");
        } else {
            displayFruitList(fruitsList, "LIST OF FRUITS: ");
            ArrayList<FruitOrdered> fruitOrderedsList = new ArrayList<>();
            String status = "";
            do {
                String customerSelectId = inputFunctions.inputStringValue("Enter ID of the item you want to buy: ","^[fF]\\d+$").toUpperCase();
                Integer customerSelectQuantity = 0;
                if(isExistItem(fruitsList, customerSelectId)) {
                    customerSelectQuantity = enterIfEnougthQuantity(fruitsList, customerSelectId);
                    if(isOrder(customerSelectId)) {
                        fruitOrderedsList.add(addFruitOrdered(fruitsList, customerSelectId, customerSelectQuantity));
                    }
                } else {
                    System.out.println("The item you seleted is not exist or quantity no longer available!");
                }
                System.out.println("Do you want to continue buy other fruit (Y/N)?");
                status = inputFunctions.inputStringValue("Enter Y-YES | N-NO :", "^(Y|y|N|n|YES|yes|NO|no)$");
            } while (status.equalsIgnoreCase("Y"));

            Integer total = displayFruitOrderedList(fruitOrderedsList, "FRUITS ORDERED LIST: ");

            if(!fruitOrderedsList.isEmpty()) {
                String custemerName = inputFunctions.inputStringValue("Enter your name to comfirm: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$");
                if(fruitOrderedsList.isEmpty() == false) {
                    Customer customer = new Customer(custemerName, total);
                    customer.setCustomeFruitOrders(fruitOrderedsList);
                    customer.setCustomerTotalOfBill(total);
                    customersList.add(customer);
                }
            }
        }
    }

    public FruitOrdered addFruitOrdered(ArrayList<Fruit> fruitsList, String customerSelectId, Integer customerSelectQuantity) {
        FruitOrdered fruitOrdered = new FruitOrdered();
        setOrderItem(fruitsList, customerSelectId, fruitOrdered, customerSelectQuantity);
        return fruitOrdered;
    }

    public boolean isOrder(String customerSelectId) {
        System.out.println("Are you sure order this item " + customerSelectId + " ?");
        String status = inputFunctions.inputStringValue("Enter Y-YES | N-NO: ", "^(Y|y|N|n|YES|yes|NO|no)$").toUpperCase();
        if(status.equals("Y")) {
            return true;
        }
        return false;
    }

    public Integer enterIfEnougthQuantity(ArrayList<Fruit> fruitsList, String str) {
        Integer quantity = 0;
        for(Fruit fruit: fruitsList ) {
            if(fruit.getFruitId().equals(str)) {
                do {
                    quantity = inputFunctions.inputNumberValue("Please enter quantity of " + fruit.getFruitName() + ": ", "^(?:1000|[1-9][0-9]{0,2}|0)$");
                    if(quantity > fruit.getFruitQuantity()) {
                        System.out.println("The quantity your enter exceeds the available quantity!");
                    }
                } while(quantity > fruit.getFruitQuantity());
            }
        }
        return quantity;
    }
    public boolean isExistItem(ArrayList<Fruit> fruitsList, String str) {
        for(Fruit fruit: fruitsList) {
            if(fruit.getFruitId().equals(str) && fruit.getFruitQuantity() > 0) {
                System.out.println("Your selected: " + fruit.getFruitName());
                return true;
            }
        }
        return false;
    }
    public void setOrderItem(ArrayList<Fruit> fruitsList, String selectId, FruitOrdered fruitOrdered, Integer quantity) {
        for(Fruit fruit: fruitsList) {
            if(fruit.getFruitId().equals(selectId)) {
                //set value for fruit order
                fruitOrdered.setProductName(fruit.getFruitName());
                fruitOrdered.setProducQuantity(quantity);
                fruitOrdered.setProducPrice(fruit.getFruitPrice());
                fruitOrdered.calculateAmount();
                //reduce quanity of fruit
                fruit.setFruitQuantity(fruit.getFruitQuantity() - quantity);
            }
        }
    }
    public Integer displayFruitOrderedList(ArrayList<FruitOrdered> fruitsOrderedList, String msg) {
        Integer total = 0;
        if(fruitsOrderedList.isEmpty()) {
            System.out.println("FRUIT ORDERED LIST IS EMPTY! HAVE NOTHING TO SHOW!");
        } else {
            System.out.println("\n" + msg);
            System.out.println("-----------------------------------------------------------------");
            System.out.format("| %5s | %18s | %8s | %10s | %8s |\n", "ITEMS", "FRUIT NAME", "PRICE", "QUANTITY", "AMOUNT");
            System.out.println("-----------------------------------------------------------------");
            for(FruitOrdered fruitOrdered : fruitsOrderedList) {
                System.out.format("| %5d | %18s | %8s | %10s | %8s |\n", fruitsOrderedList.indexOf(fruitOrdered) + 1, fruitOrdered.getProductName(), fruitOrdered.getProducPrice() + "$", fruitOrdered.getProducQuantity(), fruitOrdered.getAmount() + "$");
                total += fruitOrdered.getAmount();
                System.out.println("-----------------------------------------------------------------");
            }
            System.out.println("TOTAL OF AMOUNT: " + total + "$\n" );
        }
        return total;
    }
    public void displayOrderedList(ArrayList<Customer> customersList, String msg) {
        if(customersList.isEmpty()) {
            System.out.println("CUSTOMER LIST IS EMPTY! NOTHING TO SHOW!");
        } else {
            System.out.println("\n" + msg);
            for(Customer customer: customersList) {
                System.out.println("\n-----------------------------------------------------------------");
                System.out.println("Customer: " + customer.getCustomerName().toUpperCase());
                System.out.println("-----------------------------------------------------------------");
                System.out.format("| %5s | %18s | %8s | %10s | %8s |\n", "ITEMS", "FRUIT NAME", "PRICE", "QUANTITY", "AMOUNT");
                System.out.println("-----------------------------------------------------------------");
                for(FruitOrdered fruitOrdered: customer.getCustomeFruitOrders()) {
                    System.out.format("| %5d | %18s | %8s | %10s | %8s |\n", customer.getCustomeFruitOrders().indexOf(fruitOrdered) + 1, fruitOrdered.getProductName(), fruitOrdered.getProducPrice() + "$", fruitOrdered.getProducQuantity(), fruitOrdered.getAmount() + "$");
                    System.out.println("-----------------------------------------------------------------");
                }
                System.out.println("TOTAL OF BILL: " + customer.getCustomerTotalOfBill() + "$");
            }
        }
        System.out.println();
        waitForPressAnyKey();
    } 
}
