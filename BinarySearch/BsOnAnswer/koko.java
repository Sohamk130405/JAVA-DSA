package BinarySearch.BsOnAnswer;

public class koko {
    public int minEatingSpeed(int[] arr, int h) {
        int max = 0;
        for (int ele : arr) {
            max = Math.max(ele, max);
        }

        int lo = 1, hi = max;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(mid, arr, h)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public boolean isPossible(int maxK, int[] arr, int h) {
        long hours = 0;
        for (int i = 0; i < arr.length; i++) {
            hours += (arr[i] + maxK - 1L) / maxK;
            if (hours > h)
                return false;
        }
        return hours <= h;
    }
}
