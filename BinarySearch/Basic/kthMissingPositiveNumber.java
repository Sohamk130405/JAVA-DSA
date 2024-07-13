package BinarySearch.Basic;

public class kthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 5;
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int missed = arr[mid] - (mid + 1);
            if (missed < k)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        // kth missing is between arr[hi] and arr[lo];

        // kth missing = arr[lo] - something(x) or arr[hi] + something(x)
        // x = missing element till arr[lo] - k-1
        // x = arr[lo]-(lo+1)-k-1

        // kth missing = arr[lo] - (arr[lo]-(lo+1)-k-1)
        // kth missing = k+lo

        System.out.println(k + lo);

    }
}
