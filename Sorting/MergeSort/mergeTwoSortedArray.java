package Sorting.MergeSort;

public class mergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr = { 10, 30, 50, 90, 200, 600 };
        int[] brr = { 20, 40, 70, 100 };
        int n = arr.length;
        int m = brr.length;
        int[] crr = new int[n + m];
        merge(arr, brr, crr);
        for (int ele : crr) {
            System.out.print(ele + " ");
        }
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
