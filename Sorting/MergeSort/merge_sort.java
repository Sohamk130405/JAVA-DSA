package Sorting.MergeSort;

// Divide and conquer approach
// T.C = O(nlogn) always may or may not be good
// S.C = O(nlogn) if delete after merge --> O(n)
// =  (levels-1)*n  --> levels = logn + 1
// it is stable sorting algorithm
// Good for big datasets sorting
// linked list sorting
// custom sorting and inversion count problems

public class merge_sort {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 52, 1, 14, 5, 4 };
        print(arr);
        mergeSort(arr);
        print(arr);

    }

    private static void mergeSort(int[] arr) {

        int n = arr.length;
        if (n == 1)
            return;
        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];

        for (int i = 0; i < n / 2; i++) {
            a[i] = arr[i];
        }
        for (int i = 0; i < n - n / 2; i++) {
            b[i] = arr[i + n / 2];
        }
        mergeSort(a);
        mergeSort(b);
        merge(a, b, arr);
        a = b = null;

    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void merge(int[] a, int[] b, int[] c) {
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] <= b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }
        while (k < c.length && i == a.length) {
            c[k++] = b[j++];
        }
        while (k < c.length && j == b.length) {
            c[k++] = a[i++];
        }
    }
}
