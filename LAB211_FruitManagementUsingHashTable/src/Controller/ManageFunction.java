package Controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import Model.Fruit;
import Model.Item;
//import View.Menu;

public class ManageFunction {
	InputFunction inputFunction = new InputFunction();
	ArrayList<Fruit> fruitsList = new ArrayList<Fruit>();
	ArrayList<Item> itemsList = new ArrayList<Item>();
	Hashtable<String, ArrayList<Item>> order = new Hashtable<String, ArrayList<Item>>();
	Validation validation = new Validation();
	private final Scanner scan = new Scanner(System.in);
	
	
	
	public void addFruitForSeller(ArrayList<Fruit> fruitsList) {
		String choice ="";
		do {
			String fruitId = inputFunction.inputId("Enter fruit ID <number>", fruitsList);
			String fruitName = inputFunction.inputFruit("Enter fruit name: ");
			Integer price = inputFunction.inputNumber("Enter fruit price: ");
			Integer quantity = inputFunction.inputNumber("Enter quantity of fruit: ");
			String origin = inputFunction.inputOrigin("Enter origin of fruit: ");
			Fruit fruit = new Fruit(fruitId, fruitName, price, quantity, origin);
			fruitsList.add(fruit);
			System.out.println("Fruit data enter successfully!");
			choice = inputFunction.inputString("Do you want to continue (Y/N)?", "^(Y|y|N|n)$").toUpperCase();
		} while (choice.equalsIgnoreCase("Y"));
	}
	
	
	public void displayListOfOrders(Hashtable<String, ArrayList<Item>> order) {
		if (order.isEmpty()) {
			System.out.println("There is no order! Cannot display");
		} else {
			for (Map.Entry<String, ArrayList<Item>> entry : order.entrySet()) {
				Integer total = 0;
				System.out.println("Customer name: " + entry.getKey());
				System.out.println("----------------------------------------------");
		        System.out.format("| %10s | %7s | %5s | %10s | \n", "Product", "Quantity", "Price", "Amount");
		        System.out.println("----------------------------------------------");
				for (Item item : entry.getValue()) {
					System.out.format("| %10s | %7d | %5d | %10d | \n", item.getProduct(), item.getQuantity(), item.getPrice(), item.getAmount());
					total += item.getAmount();
					System.out.println("----------------------------------------------");
				}
				System.out.println("\nTotal bill: \n" + total);
			}
		}
		
	}
	
	
	
	public void ordering(ArrayList<Fruit> fruitsList,Hashtable<String, ArrayList<Item>> order) {
		String searchId = null;
		Fruit fruitSearch = null;
		String choice = "";
		String cont = "";
		ArrayList<Item> itemsList = new ArrayList<Item>();
		if (fruitsList.isEmpty()) {
			System.out.println("Fruit list is empty!");
		} else {
			displayFruitsList("Choose from fruits list!" , fruitsList);
			do {
				do {
					searchId = inputFunction.inputString("Enter fruit ID <number>", "^[fF]\\d+$");
					fruitSearch = validation.search(searchId, fruitsList);
					if (fruitSearch == null) {
						System.out.println("Not available product!");
					} else {
						System.out.println("You selected: " + fruitSearch.getFruitName());
						
						String fruitName = fruitSearch.getFruitName();
						if (fruitSearch.getQuantity() == 0) {
							System.out.println("Please choose another fruits! (We are not available");
							break;
						}
						Integer quantity;
						do {
							quantity = inputFunction.inputNumber("Enter quantity: ");
							if (quantity > fruitSearch.getQuantity()) System.out.println("Your order excesses our available product");
						} while (quantity <= 0 || quantity > fruitSearch.getQuantity());
						fruitSearch.setQuantity(fruitSearch.getQuantity() - quantity);
						for(Fruit fruit : fruitsList) {
							if (fruit.getFruitId().equals(searchId)) {
								fruit.setQuantity(fruitSearch.getQuantity());
//								if (fruit.getQuantity() == 0) fruitsList.remove(fruitsList.indexOf(fruit));
							}
						}
						Integer price = fruitSearch.getPrice();
						Item item = new Item(fruitName, quantity, price);
						Integer amount = item.calculateAmount();
						itemsList.add(item);
						System.out.println("Do you want to order now?(Y/N)");
						choice = scan.nextLine().toUpperCase();
						if(choice.equalsIgnoreCase("N")) {
							itemsList.remove(itemsList.indexOf(item));
						}
					}
				} while (choice.equalsIgnoreCase("N"));
				displayItemsList(itemsList);
				System.out.println("Do you want to add more? (Y/N)");
				cont = scan.nextLine().toUpperCase();
				displayFruitsList("LEFTOVER LIST", fruitsList);
			}  while (cont.equalsIgnoreCase("Y"));
			String customer = inputFunction.inputString("Enter name: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$");
			order.put(customer, itemsList);
		}
	}
		
	public void displayFruitsList(String msg, ArrayList<Fruit> fruitsList) {
        if (fruitsList.isEmpty()) {
            System.out.println("LIST OF FRUIT IS EMPTY!");
        } else {
            System.out.println("\n" + msg);
            System.out.println("------------------------------------------------------------");
            System.out.format("| %5s | %10s | %10s | %10s | %10s | \n", "ID", "Fruit", "Origin", "Price", "Quantity");
            System.out.println("------------------------------------------------------------");
            for (Fruit fruit: fruitsList) {
				System.out.format("| %5s | %10s | %10s | %10d | %10d | \n", fruit.getFruitId(), fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice(), fruit.getQuantity());
                System.out.println("------------------------------------------------------------");
            }
        }
    }
	
	public void displayItemsList(ArrayList<Item> itemsList) {
		Integer total = 0;
		System.out.println("-----------------------------------------------");
        System.out.format("| %10s | %7s | %5s | %10s | \n", "Product", "Quantity", "Price", "Amount");
        System.out.println("-----------------------------------------------");
		for (Item item : itemsList) {
			System.out.format("| %10s | %7d | %5d | %10d | \n", item.getProduct(), item.getQuantity(), item.getPrice(), item.getAmount());
			total += item.getAmount();
			System.out.println("-----------------------------------------------");
		}
		System.out.println("Total bill: " + total);
	}
}
