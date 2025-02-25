package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    // For directed acyclic graph only
    public static void main(String[] args) {
        int[][] adj = { { 2, 3 }, { 2, 4 }, {}, { 2 }, { 3, 2 } };

        System.out.println(isCycleInDirectedGraph(adj));
    }

    public static List<Integer> topologicalSortViaDFS(int[][] adj) {
        List<Integer> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if (!isVisited[i]) {
                dfs(adj, i, isVisited, ans);

            }
        }
        return ans.reversed();
    }

    public static void dfs(int[][] adj, int i, boolean[] isVisited, List<Integer> ans) {
        isVisited[i] = true;
        for (int ele : adj[i]) {
            if (!isVisited[ele]) {
                dfs(adj, ele, isVisited, ans);
            }
        }
        ans.add(i);
    }

    // Kahn's Algorithm
    public static List<Integer> topologicalSortViaBFS(int[][] adj) {
        List<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[adj.length];

        for (int i = 0; i < inDegree.length; i++) {
            for (int ele : adj[i]) {
                inDegree[ele]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.remove();
            ans.add(node);
            for (int ele : adj[node]) {
                inDegree[ele]--;
                if (inDegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        return ans;
    }

    public static boolean isCycleInDirectedGraph(int[][] adj) {
        List<Integer> ans = topologicalSortViaBFS(adj);
        return ans.size() != adj.length;
    }

}
