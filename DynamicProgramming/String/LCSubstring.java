package DynamicProgramming.String;

public class LCSubstring {
    public static void main(String[] args) {
        System.out.println(LCS("abcdef", "defghsa"));
    }

    public static int LCS(String a, String b) {
        int m = a.length(), n = b.length(), max = Integer.MIN_VALUE;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
