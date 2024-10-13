package Sorting.CyclicSort;

public class basic {
    public static void main(String[] args) {
        int[] arr = { 6, 9, 0, 7, 2, 4, 3, 8, 5, 1 };
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i) {
                swap(arr, i, arr[i]);
            } else {
                i++;
            }
        }

        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
