package BinarySearch.BsOnAnswer;

public class candies {
    public int maximumCandies(int[] arr, long k) {
        int max = 0;
        for (int ele : arr) {
            max = Math.max(ele, max);
        }

        int lo = 1, hi = max;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(mid, arr, k)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }

    public boolean isPossible(int maxC, int[] arr, long k) {
        long cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += arr[i] / maxC;
            if (cnt >= k)
                return true;
        }
        return false;
    }
}
