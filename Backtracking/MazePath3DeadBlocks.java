package Backtracking;

import java.util.Arrays;

public class MazePath3DeadBlocks {
    public static void main(String[] args) {
        int m = 4, n = 4;
        boolean[][] isVisited = new boolean[m][n];
        isVisited[2][1] = true;
        isVisited[1][0] = true;
        isVisited[3][1] = true;
        System.out.println("Total ways: " + printPaths(0, 0, m - 1, n - 1, "", isVisited));
    }

    public static int printPaths(int i, int j, int m, int n, String s, boolean[][] isVisited) {
        if (i < 0 || j < 0 || i > m || j > n)
            return 0;
        if (isVisited[i][j])
            return 0;
        if (i == m && j == n) {
            System.out.println(s);
            return 1;
        }

        isVisited[i][j] = true;
        int right = printPaths(i, j + 1, m, n, s + "R", isVisited);
        int down = printPaths(i + 1, j, m, n, s + "D", isVisited);
        int left = printPaths(i, j - 1, m, n, s + "L", isVisited);
        int up = printPaths(i - 1, j, m, n, s + "U", isVisited);
        // backtracking
        isVisited[i][j] = false;
        return right + down + left + up;
    }
}

// Leetcode UniquePaths II
class Solution {
    static int[][] dp;

    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return ways(m - 1, n - 1, arr);
    }

    public int ways(int m, int n, int[][] isVisited) {
        if (m < 0 || n < 0)
            return 0;
        if (isVisited[m][n] == 1)
            return 0;
        if (m == 0 && n == 0)
            return 1;
        if (dp[m][n] != -1)
            return dp[m][n];
        isVisited[m][n] = 1;
        int right = ways(m, n - 1, isVisited);
        int down = ways(m - 1, n, isVisited);
        isVisited[m][n] = 0;

        return dp[m][n] = right + down;

    }
}