package Sorting.MergeSort;

@SuppressWarnings("unused")
public class inversionsCount {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = { 2, 3, 52, 1, 14, 5, 4 };

        // bruteForceMethod(arr);

        mergeSortMethod(arr);
        System.out.println(count);
    }

    
    private static void bruteForceMethod(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j])
                    count++;
            }
        }

    }

    private static void mergeSortMethod(int[] arr) {

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

        mergeSortMethod(a);
        mergeSortMethod(b);
        // inversion(a, b);   for reverse Pair problem
        // merge(a, b, arr);
        mergeAndInversion(a, b, arr);
        a = b = null;
    }

    private static void inversion(int[] a, int[] b) {
        int i = 0, j = 0;
        while (j < b.length && i < a.length) {
            if (a[i] > b[j]) {
                count += a.length - i;
                j++;
            } else {
                i++;
            }
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

    public static void mergeAndInversion(int[] a, int[] b, int[] c) {
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] <= b[j])
                c[k++] = a[i++];
            else {
                count += a.length - i;
                c[k++] = b[j++];
            }
        }
        while (k < c.length && i == a.length) {
            c[k++] = b[j++];
        }
        while (k < c.length && j == b.length) {
            c[k++] = a[i++];

        }
    }
}