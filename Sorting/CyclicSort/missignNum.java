package Sorting.CyclicSort;

public class missignNum {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            if (arr[i] != i && arr[i] != n) {
                swap(arr, i, arr[i]);
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (arr[j] != j)
                return j;
        }
        return n;

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
