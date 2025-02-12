package DynamicProgramming.String;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("gabcbab"));
    }

    public static int countSubstrings(String s) {
        int n = s.length(), cnt = 0;
        boolean[][] dp = new boolean[n][n];
        for (int k = 0; k < n; k++) {
            int i = 0, j = k;
            while (j < n) {
                if (i == j) {
                    dp[i][j] = true;

                } else if (s.charAt(i) == s.charAt(j)) {
                    if (j == i + 1)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }

                if (dp[i][j])
                    cnt++;
                i++;
                j++;
            }
        }

        return cnt;
    }
}
