package BinarySearch.BsOnAnswer;

public class minMaxProducts {
    public static void main(String[] args) {
        int arr[] = {15,10,10 };

        int n = 7;

        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        
        int lo = 1;
        int hi = max;
        int maxn = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(mid, arr, n)) {
                maxn = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(maxn);
    }

    private static boolean isPossible(int maxP, int[] arr, int n) {
        int stores = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % maxP == 0) {
                stores += arr[i] / maxP;
            } else {
                stores += arr[i] / maxP + 1;
            }
        }

        if (stores > n)
            return false;
        return true;
    }
}
