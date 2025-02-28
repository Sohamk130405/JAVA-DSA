package Graph.FloydWarshall;

public class FloydAlgorithm {
    public int shortestDistance(int[][] edges, int n, int src, int dst) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k)
                    continue;
                for (int j = 0; j < n; j++) {
                    if (j == k)
                        continue;
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist[src][dst];
    }
}
