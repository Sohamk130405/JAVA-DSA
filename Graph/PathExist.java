package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathExist {
    class Solution {
        public boolean validPath(int n, int[][] edges, int start, int end) {
            if (start == end)
                return true;
            boolean[] isVisited = new boolean[n];
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < edges.length; i++) {
                int a = edges[i][0];
                int b = edges[i][1];
                adj.get(a).add(b);
                adj.get(b).add(a);
            }
            bfs(adj, start, isVisited, end);
            return isVisited[end];
        }

        public void bfs(List<List<Integer>> adj, int i, boolean[] isVisited, int end) {
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            isVisited[i] = true;
            while (!q.isEmpty()) {
                int node = q.remove();
                for (int ele : adj.get(node)) {
                    if (!isVisited[ele]) {
                        q.add(ele);
                        isVisited[ele] = true;
                        if (ele == end)
                            return;
                    }
                }
            }
        }

    }
}
