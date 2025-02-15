package DynamicProgramming.Partition;

import java.util.Arrays;

public class MatricChainMultiplication {
    public static void main(String[] args) {
        // int[][] arr = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        // int m = arr.length;
        // int[][] dp = new int[m][m];
        // for (int i = 0; i < dp.length; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // System.out.println(MCM(arr, 0, m - 1, dp));

        int[] brr = { 1, 2, 3, 4, 2 };
        int n = brr.length;
        int[][] dp = new int[n - 1][n - 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(MCM(brr, 0, n - 2, dp));
        System.out.println(MCMiterative(brr));
    }

    public static int MCM(int[][] arr, int i, int j, int[][] dp) {
        if (i == j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int x = arr[i][0] * arr[j][1] * arr[k][1];
            int cost = MCM(arr, i, k, dp) + MCM(arr, k + 1, j, dp) + x;
            minCost = Math.min(minCost, cost);
        }
        dp[i][j] = minCost;
        return minCost;
    }

    public static int MCM(int[] arr, int i, int j, int[][] dp) {
        if (i == j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int x = arr[i] * arr[j + 1] * arr[k + 1];
            int cost = MCM(arr, i, k, dp) + MCM(arr, k + 1, j, dp) + x;
            minCost = Math.min(minCost, cost);
        }
        dp[i][j] = minCost;
        return minCost;
    }

    public static int MCMiterative(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j <= n - 2; j++) {
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int x = arr[i] * arr[j + 1] * arr[k + 1];
                    int cost = dp[i][k] + dp[k + 1][j] + x;
                    minCost = Math.min(minCost, cost);
                }
                dp[i][j] = minCost;

            }
        }
        return dp[0][n - 2];
    }

}
