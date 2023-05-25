package Controller;

import java.util.ArrayList;

import Model.Customer;
import Model.Fruit;
import View.Menu;

public class FruiManagementService {
    private ArrayList<Fruit> fruitsList = new ArrayList<>();
    private ArrayList<Customer> customersList = new ArrayList<>();

    private ShopManagementFunctions shopManagementFunctions = new ShopManagementFunctions();

    public void handleCreateList() {
        String[] options = {
            "Load list of fruit from file",
            "Add fruit to list"
        };
        Menu eMenu = new Menu("CHOOSE OPTION YOU NEED", options) {

            @Override
            public void execute(int number) {
                switch(number) {
                    case 1: 
                        shopManagementFunctions.loadDataFromFile(fruitsList);
                        shopManagementFunctions.waitForPressAnyKey();
                        break;
                    case 2: 
                        shopManagementFunctions.addFruitToList(fruitsList);
                        break;
                    default: 
                        System.out.println("BACKED TO MAIN MENU!");
                        return;
                }
            }
        };
        eMenu.run();
    }
    public void handleShoppingFunction() {
        shopManagementFunctions.orderFruit(fruitsList, customersList);
    }
    public void handleDisplayCustomerList() {
        shopManagementFunctions.displayOrderedList(customersList, "ORDERED CUSTOMER LIST: ");
    }
}
