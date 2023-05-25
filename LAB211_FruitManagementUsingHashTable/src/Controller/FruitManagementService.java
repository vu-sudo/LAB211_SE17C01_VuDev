package Controller;

import java.util.ArrayList;
import java.util.Hashtable;

import Model.Fruit;
import Model.Item;


public class FruitManagementService {
	private ArrayList<Fruit> fruitsList = new ArrayList<>();
//	private ArrayList<Item> itemsList = new ArrayList<>();
	private Hashtable<String, ArrayList<Item>> order = new Hashtable<String, ArrayList<Item>>();
	private ManageFunction manageFunction = new ManageFunction();
//	private InputFunction inputFunction = new InputFunction();
	
	public ArrayList<Fruit> returnFruitsList() {
        return fruitsList;
    }
	
	public void handleAddFruits() {
		manageFunction.addFruitForSeller(fruitsList);
		manageFunction.displayFruitsList("LIST OF FRUITS", fruitsList);
	}
	
	public void handleShowOrder() {
		manageFunction.displayListOfOrders(order);
	}
	
	public void handleOrdering() {
		manageFunction.ordering(fruitsList, order);
	}
}
