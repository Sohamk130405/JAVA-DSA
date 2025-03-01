package Graph.DisjointSetUnion;

public class ConnectedComponents {

}

// union by size + path compression optimization
class NumberOfProvinces2 {
    static int[] parent;
    static int[] size;

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // edge is from i+1 to j+1
                if (i != j && isConnected[i][j] == 1)
                    union(i + 1, j + 1); // connecting group leaders of i+1 and j+1
            }
        }

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (parent[i] == i)
                cnt++;
        }

        return cnt;
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
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

    public int find(int a) {
        if (parent[a] == a)
            return a;
        // path compression
        return parent[a] = find(parent[a]);
    }
}
