package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    int parent, node;

    Pair(int node, int parent) {
        this.parent = parent;
        this.node = node;
    }
}

public class CycleDetection {
    // For Undirected Graph
    public boolean bfs(List<List<Integer>> adj, int i, boolean[] isVisited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, -1));
        isVisited[i] = true;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            for (int ele : adj.get(p.node)) {
                if (!isVisited[ele]) {
                    q.add(new Pair(ele, p.node));
                    isVisited[ele] = true;
                } else if (ele != p.parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(List<List<Integer>> adj, int i, boolean[] isVisited, int parent) {
        isVisited[i] = true;
        for (int ele : adj.get(i)) {
            if (!isVisited[ele]) {
                if (dfs(adj, ele, isVisited, i))
                    return true;
            } else if (ele != parent) {
                return true;
            }
        }
        return false;
    }
}
