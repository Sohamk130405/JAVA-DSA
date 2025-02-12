package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

// Top Down DP Using Memoization Technique
// Time Complexity: O(n)
// Space Complexity: O(n)
// Array is also called as DP table or lookup table
// Recursive DP
public class Memoization {
    static int[] dp;
    static int[][] dp2;

    public static void main(String[] args) {

    }

    // Fibonacci Number
    public int fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        if (dp[n] != 0)
            return dp[n];
        int ans = fibonacci(n - 1) + fibonacci(n - 2);
        dp[n] = ans;
        return ans;
    }

    public int fib(int n) {
        dp = new int[n + 1];
        return fibonacci(n);
    }

    // Min Cost Climbing Stairs
    public int findCost(int i, int[] cost) {
        if (i == 1 || i == 0)
            return cost[i];
        if (dp[i] != -1)
            return dp[i];
        return dp[i] = cost[i] + Math.min(findCost(i - 1, cost), findCost(i - 2, cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(findCost(n - 1, cost), findCost(n - 2, cost));
    }

    // House Robber
    public int amount(int n, int[] nums) {
        if (n < 0)
            return 0;
        if (n == 1 || n == 0)
            return nums[n];
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = nums[n] + Math.max(amount(n - 2, nums), amount(n - 3, nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.max(amount(n - 1, nums), amount(n - 2, nums));
    }

    // Friends Pairing Problem
    public int countPairs(int n) {
        if (n <= 2)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = countPairs(n - 1) + (n - 1) * countPairs(n - 2);
    }

    public int friendsPairing(int n) {
        if (n <= 2)
            return n;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return countPairs(n);
    }

    // Climbing N stairs by either 1 or 2 steps
    public int climbStairs(int n) {
        if (n <= 3)
            return n;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return countSteps(n);
    }

    public int countSteps(int n) {
        if (n <= 3)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = countSteps(n - 1) + countSteps(n - 2);
    }

    // Count number of dearrangements
    public int countDearrangements(int n) {
        if (n <= 3)
            return n - 1;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return countDer(n);
    }

    public int countDer(int n) {
        if (n <= 3)
            return n - 1;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = (n - 1) * (countDer(n - 1) + countDer(n - 2));
    }

    // Unique Paths
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        dp2 = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp2[i], -1);
        }
        return ways(m, n);
    }

    public int ways(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        if (dp2[m][n] != -1)
            return dp2[m][n];
        return dp2[m][n] = ways(m - 1, n) + ways(m, n - 1);
    }

    // Minimum Path Sum
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                sum += grid[0][i];
            }
        } else if (n == 1) {
            for (int i = 0; i < m; i++) {
                sum += grid[i][0];
            }
        } else {
            dp2 = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp2[i], -1);
            }
            sum = cost(grid, m - 1, n - 1);
        }
        return sum;
    }

    public int cost(int[][] grid, int m, int n) {
        int sum = 0;
        if (m == 0) {
            for (int i = 0; i <= n; i++) {
                sum += grid[0][i];
            }
        } else if (n == 0) {
            for (int i = 0; i <= m; i++) {
                sum += grid[i][0];
            }
        } else {
            if (dp2[m][n] != -1)
                return dp2[m][n];
            sum = grid[m][n] + Math.min(cost(grid, m - 1, n), cost(grid, m, n - 1));
            dp2[m][n] = sum;
        }
        return sum;
    }

    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n)
            return 1;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return countSquares(n);
    }

    public int countSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n / 2; i++) {
            int c1 = dp[i * i] != -1 ? dp[i * i] : countSquares(i * i);
            int c2 = dp[n - i * i] != -1 ? dp[n - i * i] : countSquares(n - i * i);
            int count = c1 + c2;
            min = Math.min(count, min);
        }
        return dp[n] = min;
    }

    public int Knapsack(int[] wt, int[] val, int capacity) {
        dp2 = new int[wt.length][capacity + 1];
        for (int i = 0; i < wt.length; i++) {
            Arrays.fill(dp2[i], -1);
        }
        return profit(0, wt, val, capacity);
    }

    public int profit(int i, int[] wt, int[] val, int C) {
        if (i == wt.length)
            return 0;
        if (dp2[i][C] != -1)
            return dp2[i][C];
        int skip = profit(i + 1, wt, val, C);
        if (wt[i] > C)
            return dp2[i][C] = skip;
        int pick = val[i] + profit(i + 1, wt, val, C - wt[i]);
        return dp2[i][C] = Math.max(skip, pick);
    }

    
    public boolean subsetSum(int[] arr, int target) {
        dp2 = new int[arr.length][target + 1];
        for (int i = 0; i < dp2.length; i++) {
            Arrays.fill(dp2[i], -1);
        }
        return isSubsetFound(0, arr, target);
    }

    public boolean isSubsetFound(int i, int[] arr, int target) {
        if (i == arr.length) {
            if (target == 0)
                return true;
            else
                return false;
        }
        if (dp2[i][target] != -1)
            return dp2[i][target] == 1;
        boolean ans = false;
        boolean skip = isSubsetFound(i + 1, arr, target);
        if (target - arr[i] < 0)
            ans = skip;
        else {
            boolean pick = isSubsetFound(i + 1, arr, target - arr[i]);
            ans = pick || skip;
        }
        dp2[i][target] = ans ? 1 : 0;
        return ans;
    }

    public int lengthOfLongestSubsequence(List<Integer> arr, int target) {
        dp2 = new int[arr.size()][target + 1];
        for (int i = 0; i < dp2.length; i++) {
            Arrays.fill(dp2[i], -1);
        }
        int ans = SubsqLen(0, arr, target);
        return ans > 0 ? ans : -1;
    }

    public int SubsqLen(int i, List<Integer> arr, int target) {
        if (i == arr.size()) {
            if (target == 0)
                return 0;
            else
                return Integer.MIN_VALUE;
        }
        if (dp2[i][target] != -1)
            return dp2[i][target];
        int skip = SubsqLen(i + 1, arr, target);
        if (target - arr.get(i) < 0)
            return dp2[i][target] = skip;
        int pick = 1 + SubsqLen(i + 1, arr, target - arr.get(i));
        return dp2[i][target] = Math.max(pick, skip);
    }

    static int sum; // instead this we can use hashmap

    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        dp2 = new int[nums.length][2 * sum + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp2[i], -1);
        }
        return findWays(0, nums, target, 0);
    }

    public int findWays(int i, int[] arr, int target, int res) {
        if (i == arr.length) {
            if (res == target)
                return 1;
            else
                return 0;
        }
        if (dp2[i][res + sum] != -1)
            return dp2[i][res + sum];
        int add = findWays(i + 1, arr, target, res - arr[i]);
        int sub = findWays(i + 1, arr, target, res + arr[i]);
        return dp2[i][res + sum] = add + sub;
    }

    // Longest Common Subsequence
    public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder a = new StringBuilder(text1);
        StringBuilder b = new StringBuilder(text2);
        int m = a.length(), n = b.length();
        dp2 = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp2[i], -1);
        }
        return LCS(a, b, m, n);
    }

    public int LCS(StringBuilder a, StringBuilder b, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (dp2[m - 1][n - 1] != -1)
            return dp2[m - 1][n - 1];
        if (a.charAt(m - 1) == b.charAt(n - 1))
            return dp2[m - 1][n - 1] = 1 + LCS(a, b, m - 1, n - 1);
        return dp2[m - 1][n - 1] = Math.max(LCS(a, b, m, n - 1), LCS(a, b, m - 1, n));
    }

    // Longest Common Palindrome Subsequence
    public int longestPalindromeSubseq(String s) {
        StringBuilder a = new StringBuilder(s);
        int m = a.length();
        dp2 = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp2[i], -1);
        }
        return LPS(a, m, 0);
    }

    public int LPS(StringBuilder a, int m, int n) {
        if (m == 0 || n == a.length())
            return 0;
        if (dp2[m - 1][n] != -1)
            return dp2[m - 1][n];
        if (a.charAt(m - 1) == a.charAt(n))
            return dp2[m - 1][n] = 1 + LPS(a, m - 1, n + 1);
        return dp2[m - 1][n] = Math.max(LPS(a, m, n + 1), LPS(a, m - 1, n));
    }

    // Delete Operation For 2 Strings
    public int minDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);
        int m = a.length(), n = b.length();
        dp2 = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp2[i], -1);
        }
        return m + n - 2 * LCS(a, b, m, n);
    }

    public int editDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);
        int m = a.length(), n = b.length();
        dp2 = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp2[i], -1);
        }
        return edit(a, b, m - 1, n - 1);
    }

    public int edit(StringBuilder a, StringBuilder b, int m, int n) {
        if (m == -1)
            return n + 1;
        if (n == -1)
            return m + 1;
        if (dp2[m][n] != -1)
            return dp2[m][n];
        if (a.charAt(m) == b.charAt(n))
            return dp2[m][n] = edit(a, b, m - 1, n - 1);
        int rep = edit(a, b, m - 1, n - 1);
        int del = edit(a, b, m - 1, n);
        int ins = edit(a, b, m, n - 1);
        return dp2[m][n] = 1 + Math.min(Math.min(rep, del), ins);
    }
   
    public int unboundedKnapsack(int[] wt, int[] val, int capacity) {
        dp2 = new int[wt.length][capacity + 1];
        for (int i = 0; i < wt.length; i++) {
            Arrays.fill(dp2[i], -1);
        }
        return unboundedProfit(0, wt, val, capacity);
    }

    public int unboundedProfit(int i, int[] wt, int[] val, int C) {
        if (i == wt.length)
            return 0;
        if (dp2[i][C] != -1)
            return dp2[i][C];
        int skip = unboundedProfit(i + 1, wt, val, C);
        if (wt[i] > C)
            return dp2[i][C] = skip;
        int pick = val[i] + unboundedProfit(i, wt, val, C - wt[i]);
        return dp2[i][C] = Math.max(skip, pick);
    }

    public int coinChange(int[] coins, int amount) {
        long[][] dp;
        dp = new long[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = (int) coins(0, coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public long coins(int i, int[] coins, int amount, long[][] dp) {
        if (i == coins.length) {
            if (amount == 0)
                return 0;
            else
                return Integer.MAX_VALUE;
        }
        if (dp[i][amount] != -1)
            return dp[i][amount];
        long skip = coins(i + 1, coins, amount, dp);
        if (coins[i] > amount)
            return dp[i][amount] = skip;
        long pick = 1 + coins(i, coins, amount - coins[i], dp);
        return dp[i][amount] = Math.min(skip, pick);
    }
    
}
