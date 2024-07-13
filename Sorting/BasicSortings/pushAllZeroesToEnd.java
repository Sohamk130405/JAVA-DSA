package Sorting.BasicSortings;

public class pushAllZeroesToEnd {

    public static void main(String[] args) {
        int[] arr = { 1, 0, 4, 0, 2, -40, 100, 0, 5 };

        print(arr);

        bubbleSortZero(arr);

        print(arr);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void bubbleSortZero(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j]==0) {
                    swap(arr, j+1, j);
                    flag = false;
                }
            }
            if (flag)
                break;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
