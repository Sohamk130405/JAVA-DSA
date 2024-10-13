package Sorting.CyclicSort;

public class duplicateNum {
    public int findDuplicate(int[] arr) {
        while (true) {
            if (arr[0] == arr[arr[0]])
                return arr[0];
            swap(arr, 0, arr[0]);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
