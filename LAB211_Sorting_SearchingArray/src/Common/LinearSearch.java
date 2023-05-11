package Common;

import java.util.ArrayList;

public class LinearSearch {
    public Integer linearSearchFunction(ArrayList<Integer> arr, int key) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == key) {
                return i;
            }
        }
        return -1;
    }
}
