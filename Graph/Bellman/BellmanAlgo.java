package Graph.Bellman;

import java.util.Arrays;

public class BellmanAlgo {
    public boolean isNegativeCycle(int[][] edges, int n, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        // for sortest distance
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }
        // for detecting negative cycle
        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
               return true;
        }
        return false;
    }
}
