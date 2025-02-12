package DynamicProgramming.String;

public class longestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}