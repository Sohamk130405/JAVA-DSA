package Graph.Prims;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int node;
    int wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

class Triplet implements Comparable<Triplet> {
    int node;
    int parent;
    int wt;

    public Triplet(int node, int parent, int wt) {
        this.node = node;
        this.parent = parent;
        this.wt = wt;
    }

    public int compareTo(Triplet t) {
        return Integer.compare(this.wt, t.wt);
    }
}

public class PrimsAlgo {
    public static void main(String[] args) {
        int n = 5;
        int[][] graph = {
                { 0, 1, 2 },
                { 0, 3, 6 },
                { 1, 3, 8 },
                { 1, 2, 3 },
                { 1, 4, 5 },
                { 2, 4, 7 }
        };

        List<List<Integer>> mst = minimumSpanningTree(n, graph);
        System.out.println("Edges in MST: " + mst);
    }

    public static List<List<Integer>> minimumSpanningTree(int n, int[][] graph) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list
        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        List<List<Integer>> mst = new ArrayList<>();
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[n];
        int sum = 0;

        pq.add(new Triplet(0, -1, 0));

        while (!pq.isEmpty()) {
            Triplet t = pq.remove();
            int node = t.node;
            int wt = t.wt;
            int parent = t.parent;

            if (isVisited[node])
                continue;

            isVisited[node] = true;
            sum += wt;

            if (parent != -1) {
                List<Integer> edge = new ArrayList<>();
                edge.add(node);
                edge.add(parent);
                edge.add(wt);
                mst.add(edge);
            }

            for (Pair ele : adj.get(node)) {
                if (!isVisited[ele.node] && ele.node !=parent) {
                    pq.add(new Triplet(ele.node, node, ele.wt));
                }
            }
        }

        System.out.println("Total Weight of MST: " + sum);
        return mst;
    }
}
