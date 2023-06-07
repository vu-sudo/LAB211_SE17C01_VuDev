package Common;

import java.util.ArrayList;

public class BubbleSort {

    public void bubbleSortFunctionAscending(ArrayList<Integer> integerArray) {
        int number = integerArray.size();
        for (int i = 0; i < number - 1; i++) {
            for (int j = 0; j < number - i - 1; j++) {
                if (integerArray.get(j) > integerArray.get(j + 1)) {
                    int temp = integerArray.get(j);
                    integerArray.set(j, integerArray.get(j + 1));
                    integerArray.set(j + 1, temp);
                }
            }
        }
    }

    public void bubbleSortFunctionDescending(ArrayList<Integer> integerArray) {
        int number = integerArray.size();
        for (int i = 0; i < number - 1; i++) {
            for (int j = 0; j < number - i - 1; j++) {
                if (integerArray.get(j) < integerArray.get(j + 1)) {
                    int temp = integerArray.get(j);
                    integerArray.set(j, integerArray.get(j + 1));
                    integerArray.set(j + 1, temp);
                }
            }
        }
    }
}
