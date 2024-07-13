package Sorting.QuickSort;
// T.C = O(2n) = O(n)
public class quick_select {

    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 18, 9, 0 };
        print(arr);
        int n = arr.length;
        int k = 1;
        int small = quickSelect(arr, 0, n - 1, k); // kth smallest element
        int large = quickSelect(arr, 0, n - 1, n - k + 1); // kth smallest element
        System.out.println(large + " " + small);
    }

    private static int quickSelect(int[] arr, int lo, int hi, int k) {
        if (lo > hi)
            return -1;
        if (lo == hi)
            return arr[lo];
        int idx = partitionRandomised(arr, lo, hi);

        if (k == idx + 1)
            return arr[idx];
        if (k > idx + 1) {
            return quickSelect(arr, idx + 1, hi, k);// right part
        } else {
            return quickSelect(arr, lo, idx - 1, k); // left part
        }

    }

    private static int partitionRandomised(int[] arr, int lo, int hi) {
        int smallCount = 0;
        int mid = (lo + hi) / 2;
        int pivot = arr[mid], pivotIdx = mid;

        for (int i = lo; i <= hi; i++) {
            if (i == mid)
                continue;
            if (arr[i] <= pivot)
                smallCount++;
        }
        int correctIdx = lo + smallCount;
        swap(arr, pivotIdx, correctIdx);

        int i = lo, j = hi;

        while (i < correctIdx && j > correctIdx) {
            if (arr[i] <= pivot)
                i++;
            if (arr[j] > pivot)
                j--;
            else if (arr[i] > pivot && arr[j] <= pivot) {
                swap(arr, i, j);
            }
        }
        return correctIdx;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
