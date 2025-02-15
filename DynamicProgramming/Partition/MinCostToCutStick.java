package DynamicProgramming.Partition;

import java.util.Arrays;

public class MinCostToCutStick {
    public static void main(String[] args) {
        int[] cuts = { 1, 3, 4, 5 };
        int n = 7;
        int[] arr = new int[cuts.length + 2];
        int i;
        for (i = 0; i < cuts.length; i++) {
            arr[i] = cuts[i];
        }
        arr[i++] = 0;
        arr[i] = n;
        Arrays.sort(arr);
        int m = arr.length;
        int[][] dp = new int[m - 1][m - 1];
        for (int j = 0; j < dp.length; j++) {
            Arrays.fill(dp[j], -1);
        }
        System.out.println(cost(1, arr.length - 2, arr, dp));
    }

    public static int cost(int i, int j, int[] arr, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int len = arr[j + 1] - arr[i - 1];
            int total = cost(i, k - 1, arr, dp) + cost(k + 1, j, arr, dp) + len;
            minCost = Math.min(minCost, total);
        }
        return dp[i][j] = minCost;
    }
}
