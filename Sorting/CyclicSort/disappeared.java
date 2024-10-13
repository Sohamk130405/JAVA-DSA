package Sorting.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class disappeared {

    public List<Integer> findDisappearedNumbers(int[] arr) {
        int n = arr.length;
        List<Integer> al = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (arr[i] == arr[arr[i] - 1] || arr[i] == i + 1)
                i++;
            else
                swap(arr, i, arr[i] - 1);

        }
        for (int j = 0; j < n; j++) {
            if (arr[j] != j + 1)
                al.add(j + 1);
        }
        return al;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
