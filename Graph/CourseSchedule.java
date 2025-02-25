package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < pre.length; i++) {
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(b).add(a);
            inDegree[a]++;
        }

        // Kahn's Algorithm
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.remove();
            ans.add(node);
            for (int ele : adj.get(node)) {
                inDegree[ele]--;
                if (inDegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        return ans.size() == n;
    }

    static boolean isCycle;

    public boolean canFinishUsingDFS(int n, int[][] pre) {
        isCycle = true;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < pre.length; i++) {
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(b).add(a);
        }
        boolean[] isVisited = new boolean[n];
        boolean[] path = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(adj, i, isVisited, path);
            }
        }
        return isCycle;
    }

    public void dfs(List<List<Integer>> adj, int i, boolean[] isVisited, boolean[] path) {
        isVisited[i] = true;
        path[i] = true;
        for (int ele : adj.get(i)) {
            if (path[ele]) {
                isCycle = false;
                return;
            }
            if (isVisited[ele])
                dfs(adj, ele, isVisited, path);
        }
        path[i] = false;
    }
}
