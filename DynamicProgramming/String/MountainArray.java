package DynamicProgramming.String;

public class MountainArray {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += 1;
        }
        int[] dp2 = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j])
                    dp2[i] = Math.max(dp2[i], dp2[j]);
            }
            dp2[i] += 1;
        }
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > 1 && dp2[i] > 1) {
                dp[i] = (dp[i] + dp2[i] - 1);
                maxLen = Math.max(maxLen, dp[i]);
            }

        }
        if (maxLen < 3)
            return 0;
        return n - maxLen;
    }
}
