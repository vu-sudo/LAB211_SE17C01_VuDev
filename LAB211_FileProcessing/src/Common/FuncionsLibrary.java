package Common;

import java.util.ArrayList;

import Model.Maxmin;
import Model.Person;

public class FuncionsLibrary {
    InputFunctions inputFunction = new InputFunctions();
    DataProcessing dataProcessing = new DataProcessing();

    public void handleLoadDataFromFile(ArrayList<Person> personList, String path) {
        personList.clear();
        dataProcessing.loadDataFromFile(path, personList);
    }
    public void handleSaveCopy(ArrayList<Person> personList, String path) {
        dataProcessing.saveDataToFile(path, personList);
    }
    public ArrayList<Person> founedResult(ArrayList<Person> personList, Double searcValue) {
        ArrayList<Person> tempList = new ArrayList<>();
        for (Person person: personList) {
            if(person.getMoney() >= searcValue) {
                tempList.add(person);
            }
        }
        return tempList;
    }

    public void handleFindPersons(ArrayList<Person> personList, Double searcValue) {
        ArrayList<Person> resulList = founedResult(personList,searcValue);
        displayPersonInfo(resulList, "PERSONS FOUNDED: "); 
        Maxmin maxmin = new Maxmin();

        Double maxValue = resulList.get(0).getMoney();
        Double minValue = resulList.get(0).getMoney();
        for(Person person: resulList) {
            if(person.getMoney() > maxValue) maxValue = person.getMoney();
            if(person.getMoney() < minValue) minValue = person.getMoney();
        }
        for(Person person: resulList) {
            if(person.getMoney().equals(maxValue)) {
                maxmin.setMax(person);
            }
            if(person.getMoney().equals(minValue)) {
                maxmin.setMin(person);
            }
        }
        System.out.println(maxmin);
    }
    
    public void displayPersonInfo(ArrayList<Person> personList, String msg) {
        if(personList.isEmpty()) {
            System.out.println("COUNTRY LIST IS EMPTY! PLEASE INPUT COUNTRY TO SHOW!");
        } else {
            System.out.println("\n" + msg);
            System.out.println("\n-------------------------------------------------------");
            System.out.format("| %15s | %15s | %15s |", "NAME", "ADDRESS" , "MONEY");
            System.out.println("\n-------------------------------------------------------");
            for(Person person: personList) {
                System.out.format("| %15s | %15s | %15.1f |", person.getName(), person.getAddress(), person.getMoney());
                System.out.println("\n-------------------------------------------------------");
            }
        }
    }
}
