package DynamicProgramming.String;

import java.util.Arrays;

public class RussianDoll {
    public class Envelop implements Comparable<Envelop> {
        int w;
        int h;

        Envelop(int w, int h) {
            this.w = w;
            this.h = h;
        }

        public int compareTo(Envelop e) {
            if (this.w == e.w)
                return e.h - this.h;
            return this.w - e.w;
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Envelop[] arr = new Envelop[n];
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            int w = envelopes[i][0];
            int h = envelopes[i][1];
            arr[i] = new Envelop(w, h);
        }
        Arrays.sort(arr);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].h > arr[j].h)
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
