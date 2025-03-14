package BinarySearch.BsOnAnswer;

public class Bags {

    public int minimumSize(int[] arr, int n) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int lo = 1, hi = max;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(mid, arr, n)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public boolean isPossible(int maxP, int[] arr, int n) {
        int ops = 0;
        for (int i = 0; i < arr.length; i++) {
            ops += (arr[i] - 1) / maxP;
            if (ops > n)
                return false;
        }
        return true;
    }
}
