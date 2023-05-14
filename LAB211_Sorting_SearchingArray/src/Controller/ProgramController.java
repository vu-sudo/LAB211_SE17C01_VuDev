package Controller;

import Common.BinarySearch;
import Common.BubbleSort;
import Common.LinearSearch;
import Common.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProgramController {
    private final ArrayList<Integer> integerArrayList = new ArrayList<>();
    private static  final Scanner scan = new Scanner(System.in);

    public Boolean isSorted = false;
    BubbleSort bubbleSort = new BubbleSort();
    QuickSort quickSort = new QuickSort();
    LinearSearch linearSearch = new LinearSearch();
    BinarySearch binarySearch = new BinarySearch();

    public void generateArray() {
        isSorted = false;
        integerArrayList.clear();
        int number = getNumber();
        Integer[] list = randomValue(number);
        integerArrayList.addAll(Arrays.asList(list));
        displayArray();
    }
    public ArrayList<Integer> returnArray() {
        return integerArrayList;
    }
    public Integer[] randomValue(int number) {
        Integer[] list = new Integer[number];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random()*100);
        }
        return list;
    }
    public void displayArray() {
        System.out.println("YOUR ARRAY IS: <length: "+integerArrayList.size()+">");
        System.out.println(integerArrayList);
        System.out.println();
    }
    public Integer getNumber() {
        int number = -1;

      do {
          try{
              System.out.println("Enter a positive number");
              number = Integer.parseInt(scan.nextLine());
          } catch (NumberFormatException e) {
              System.err.println("Enter failed, pls enter again!");
          }
      } while (number < 0);
        return  number;
    }
    public void executeBubbleSort() {
        bubbleSort.bubbleSortFunction(integerArrayList);
        isSorted = true;
    }
    public void executeQuickSort() {
        quickSort.quickSortFunction(integerArrayList, 0, integerArrayList.size() - 1);
        isSorted = true;
    }
    public void executeLinearSearch() {
        if(!isSorted) {
            System.out.println("THIS ARRAY OF NUMBER MUST BE SORTED BEFORE IMPLEMENT LINEAR SEARCH!");
        } else {
            int key = 0;
            key = getNumber();
            int index = linearSearch.linearSearchFunction(integerArrayList, key);
            if (index != -1) {
                System.out.println("Key found at index: " + index);
            } else {
                System.out.println("Key not found!");
            }
        }
    }
    public void executeBinarySearch() {
        if(!isSorted) {
            System.out.println("THIS ARRAY OF NUMBER MUST BE SORTED BEFORE IMPLEMENT BINARY SEARCH!");
        } else {
            int key = 0;
            key = getNumber();
            int index = binarySearch.binarySearchFunction(integerArrayList, key);
            if (index != -1) {
                System.out.println("Key found at index: " + index);
            } else {
                System.out.println("Key not found!");
            }
        }
    }
}
