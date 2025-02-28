package Graph.Bellman;

import java.util.Arrays;

// shortest distance using Bellman Ford Algo
class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int src) {
        int[] timing = new int[n + 1];
        Arrays.fill(timing, Integer.MAX_VALUE);
        timing[src] = 0;

        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j < times.length; j++) {
                int u = times[j][0];
                int v = times[j][1];
                int wt = times[j][2];
                if (timing[u] != Integer.MAX_VALUE && timing[u] + wt < timing[v])
                    timing[v] = timing[u] + wt;
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (timing[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, timing[i]);
        }
        return max;
    }
}