package Graph.DisjointSetUnion;

public class Bipartite {
    static int[] parent;
    static int[] size;
    static boolean[] parity;

    public void union(int u, int v) {
        int a = leader(u);
        int b = leader(v);
        if (a != b) {
            if (size[a] > size[b]) {
                parent[b] = a;
                size[a] += size[b];
                parity[v] = !parity[u];
            } else {
                parent[a] = b;
                size[b] += size[a];
                parity[u] = !parity[v];
            }
        }
    }

    public int leader(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = leader(parent[a]);
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        parent = new int[n];
        size = new int[n];
        parity = new boolean[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int u = 0; u < n; u++) {
            for (int j = 0; j < graph[u].length; j++) {
                int v = graph[u][j];
                if (v > u) {
                    if (leader(u) == leader(v)) {
                        if (parity[u] == parity[v])
                            return false;
                    } else {
                        union(u, v);
                    }
                }
            }
        }
        return true;
    }
}
