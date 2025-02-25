package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SafeNode {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) 
            adj.add(new ArrayList<>());
        
        for (int i = 0; i < graph.length; i++) {
            for (int ele : graph[i]) {
                adj.get(ele).add(i);
                inDegree[i]++;
            }
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
        Collections.sort(ans);
        return ans;
    }
}
