package Graph.DisjointSetUnion;

public class RedundantConnections {
    static int[] parent;
    static int[] size;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (leader(u) == leader(v))
                return edge;
            union(u, v);
        }
        return edges[0];
    }

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
        return parent[a] = leader(parent[a]);
    }
}
