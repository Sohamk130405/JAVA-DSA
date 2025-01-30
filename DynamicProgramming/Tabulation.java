package DynamicProgramming;

// Bottom Up DP Using Tabulation Technique
// Time Complexity: O(n)
// Space Complexity: O(n)
// Iterative DP
public class Tabulation {
    public static void main(String[] args) {

    }

    public int fib(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int take = nums[i] + (i > 1 ? dp[i - 2] : 0);
            int skip = dp[i - 1];
            dp[i] = Math.max(take, skip);
        }
        return dp[n - 1];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        return Math.max(amount(nums, 0, n - 2), amount(nums, 1, n - 1));
    }

    public int amount(int[] nums, int start, int end) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[start] = nums[start];
        for (int i = start + 1; i <= end; i++) {
            int take = nums[i] + (i > start + 1 ? dp[i - 2] : 0);
            int skip = dp[i - 1];
            dp[i] = Math.max(take, skip);
        }
        return dp[end];
    }

    public static int friendsPairing(int n) {
        if (n <= 2)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs(int n) {
        if (n <= 3)
            return n;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= 3; i++) {
            dp[i] = i;
        }
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }

            }
        }
        return dp[m - 1][n - 1];
    }

    public int minPathSum(int[][] grid) {
        // instead extra dp array we utillize grid
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 & j == 0)
                    continue;
                else if (i == 0)
                    grid[i][j] += grid[i][j - 1];
                else if (j == 0)
                    grid[i][j] += grid[i - 1][j];
                else
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    // Count Squares
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    continue;
                else if (i > 0 && j > 0)
                    matrix[i][j] += Math.min(Math.min(matrix[i][j - 1], matrix[i - 1][j]), matrix[i - 1][j - 1]);
                count += matrix[i][j];
            }
        }
        return count;
    }
    
    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n)
            return 1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i)
                dp[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    int cnt = dp[j * j] + dp[i - j * j];
                    min = Math.min(min, cnt);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
