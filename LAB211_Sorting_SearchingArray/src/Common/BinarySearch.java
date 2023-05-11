package Common;

import java.util.ArrayList;

public class BinarySearch {
    public Integer binarySearchFunction(ArrayList<Integer> arr, int key) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr.get(mid) == key) {
                return mid;
            } else if (arr.get(mid) < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
