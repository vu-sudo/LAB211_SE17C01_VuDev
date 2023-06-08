package Common;

import java.util.ArrayList;

public class QuickSort {
    public void quickSortFunction(ArrayList<Integer> arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSortFunction(arr, left, pivotIndex - 1);
            quickSortFunction(arr, pivotIndex + 1, right);
        }
    }

     private int partition(ArrayList<Integer> arr, int left, int right) {
        int pivot = arr.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr.get(j) <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
