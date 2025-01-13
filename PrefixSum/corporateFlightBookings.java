package PrefixSum;

public class corporateFlightBookings {
    // M1. Brute Force
    // M2. Optimized via Prefix Sum
}

class Solution {
    public int[] corpFlightBookings(int[][] arr, int n) {
        int m = arr.length;
        int ans[] = new int[n];
        for (int i = 0; i < m; i++) {
            int first = arr[i][0];
            int last = arr[i][1];
            int val = arr[i][2];
            ans[first - 1] += val;
            if (last < n)
                ans[last] -= val;
        }

        for (int i = 1; i < n; i++)
            ans[i] += ans[i - 1];
        return ans;
    }
}