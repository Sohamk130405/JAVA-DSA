package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] adj = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(findCircleNum(adj));
    }

    public static int findCircleNum(int[][] adj) {
        int cnt = 0;
        boolean[] isVisited = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if (!isVisited[i]) {
                bfs(adj, i, isVisited);
                cnt++;
            }
        }
        return cnt;
    }

    public static void bfs(int[][] adj, int i, boolean[] isVisited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        isVisited[i] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            for (int j = 0; j < adj.length; j++) {
                if (adj[node][j] == 1 && !isVisited[j]) {
                    q.add(j);
                    isVisited[j] = true;
                }
            }
        }
    }

    public static void dfs(int[][] adj, int i, boolean[] isVisited) {
        isVisited[i] = true;
        for (int j = 0; j < adj.length; j++) {
            if (adj[i][j] == 1 && !isVisited[j]) {
                dfs(adj, j, isVisited);
            }
        }
    }
}
