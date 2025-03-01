package Graph.DisjointSetUnion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge> {

    int u, v, dist;

    public Edge(int u, int v, int dist) {
        this.u = u;
        this.v = v;
        this.dist = dist;
    }

    public int compareTo(Edge t) {
        return Integer.compare(this.dist, t.dist);
    }
}

public class KruskalAlgorithm {
    static int[] parent;
    static int[] size;

    public void union(int a, int b) {
        a = leader(a);
        b = leader(b);
        if (a != b) {
            if (size[a] > size[b]) {
                parent[b] = a;
                size[a] += size[b];
            } else {
                parent[a] = b;
                size[b] += size[a];
            }
        }

    }

    public int leader(int a) {
        if (parent[a] == a)
            return a;
        // path compression
        return parent[a] = leader(parent[a]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int cost = 0;

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        List<Edge> edges = new ArrayList<>();
        for (int u = 0; u < n; u++) {
            int x1 = points[u][0];
            int y1 = points[u][1];
            for (int v = u + 1; v < n; v++) {
                int x2 = points[v][0];
                int y2 = points[v][1];
                int dist = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                edges.add(new Edge(u, v, dist));
            }
        }
        Collections.sort(edges);
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int dist = edge.dist;
            if (leader(u) != leader(v)) {
                union(u, v);
                cost += dist;
            }
        }
        return cost;
    }
}