package Controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Fruit;

public class Validation {
	public boolean validatePattern(String str, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	public Fruit search(String searchId, ArrayList<Fruit> fruitsList) {
		searchId = searchId.trim().toUpperCase();
		for (Fruit fruit : fruitsList) {
			if (fruit.getFruitId().equals(searchId)) {
				return fruit;
			}
		}
		return null;
	}
	
	public boolean isDuplicated(String string, ArrayList<Fruit> fruitsList) {
		string = string.trim().toUpperCase();
		return search(string, fruitsList) != null;
	}
}
