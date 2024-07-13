package Recursion.Arrays;

public class print {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 6, 4, 5 };

        printArray(arr, arr.length - 1);
    }

    private static void printArray(int[] arr, int n) {
        if (n == -1)
            return;
        printArray(arr, n - 1);
        System.out.print(arr[n]+" ");
    }
}
