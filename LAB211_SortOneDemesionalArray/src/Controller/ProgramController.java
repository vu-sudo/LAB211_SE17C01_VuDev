package Controller;

import java.util.ArrayList;

import Common.BubbleSort;
import Common.InputFunctions;
import View.Menu;

public class ProgramController {
    ArrayList<Integer> integersList = new ArrayList<>();
    
    InputFunctions inputFunctions = new InputFunctions();
    BubbleSort bubbleSort = new BubbleSort();

    public void handleInputItems() {
        String[] eOptions= {
            "Generate items of array",
            "Manual input items of array",
        };
        Menu eMenu = new Menu("CHOOSE THE OPTION", eOptions) {

            @Override
            public void execute(int number) {
                switch(number) {
                    case 1: 
                        inputFunctions.generateArray(integersList); 
                        displayArray();
                        break;
                    case 2: 
                        inputFunctions.inputItems(integersList); 
                        displayArray();
                        break;
                    default: 
                        System.out.println("Backed to maim menu!");
                        return;
                }
            }
            
        };
        eMenu.run();
    }

    public void handleSortAscending() {
        bubbleSort.bubbleSortFunctionAscending(integersList);
        displaySortedArray("ASCENDING","->");
    }
    public void handleSortDescending() {
        bubbleSort.bubbleSortFunctionDescending(integersList);
        displaySortedArray("DESCENDING", "<-");
    }
    public void displayArray() {
        System.out.println("YOUR ARRAY IS: <length: " + integersList.size()+">");
        System.out.println(integersList);
        System.out.println();
    }
    
    public void displaySortedArray(String msg, String arrow) {
        if(integersList.isEmpty()) {
            System.out.println("List of integer number is empty! can't execute this function!");
        } else {
            System.out.println("YOUR ARRAY AFTER SORTED " + msg + ":");
            System.out.println();
            for(Integer integer: integersList) {
                System.out.print("[" + integer + "]" + (integersList.indexOf(integer) == integersList.size() - 1 ? "" : arrow));
            }
            System.out.println();
        }
    }
}
