package Sorting.QuickSort;

//T.C = O(nlogn)
// worst case(sorted) T.C= O(n)  S.C = O(n)
//S.C = O(logn) or O(1) kind of constant space
// UNSTABLE Sorting
@SuppressWarnings("unused")
public class quick_sort {
    public static void main(String[] args) {
        int[] arr = { 4, 9, 7, 1, 2, 3, 6, 5, 8 };
        print(arr);
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        print(arr);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi)
            return;
        // int idx = partition(arr, lo, hi); // find exact position of arr[lo] and find partition idx
        int idx = partitionRandomised(arr, lo, hi); // worst case T.C = O(nlogn)  find exact position of arr[mid] and find partition
                                                    
        quickSort(arr, idx + 1, hi); // right part
        quickSort(arr, lo, idx - 1); // left part
    }

    
    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int pivotIdx = lo;
        int smallCount = 0;
        for (int i = lo + 1; i <= hi; i++) {
            if (arr[i] <= pivot)
                smallCount++;
        }
        int correctIdx = lo + smallCount;
        swap(arr, lo, correctIdx);

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
