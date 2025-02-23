package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if ((color[i] == -1 && !bfs(graph, i, color))) {
                return false;
            }
        }
        return true;
    }

    public boolean bfs(int[][] adj, int i, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            for (int ele : adj[node]) {
                if (color[ele] == color[node]) {
                    return false;
                }
                if (color[ele] == -1) {
                    q.add(ele);
                    color[ele] = 1 - color[node];
                }
            }
        }
        return true;
    }

    public boolean dfs(int[][] adj, int i, int[] color) {
        if (color[i] == -1) {
            color[i] = 0;
        }
        for (int ele : adj[i]) {
            if (color[ele] == color[i]) {
                return false;
            } else if (color[ele] == -1) {
                color[ele] = 1 - color[i];
                if (!dfs(adj, ele, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
