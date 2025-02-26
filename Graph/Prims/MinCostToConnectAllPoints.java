package Graph.Prims;


import java.util.PriorityQueue;

class Triplet implements Comparable<Triplet> {

    int node, parent, dist;

    public Triplet(int node, int parent, int dist) {
        this.node = node;
        this.parent = parent;
        this.dist = dist;
    }

    public int compareTo(Triplet t) {
        return Integer.compare(this.dist, t.dist);
    }
}

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int sum = 0;

        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[n];
        pq.add(new Triplet(0, -1, 0));
        while (!pq.isEmpty()) {
            Triplet t = pq.remove();
            int node = t.node;
            int dist = t.dist;
            int parent = t.parent;

            if (isVisited[node])
                continue;
            isVisited[node] = true;
            sum += dist;

            int x1 = points[node][0];
            int y1 = points[node][1];

            for (int i = 0; i < n; i++) {
                if (i == node || isVisited[i] || i == parent)
                    continue;
                int x2 = points[i][0];
                int y2 = points[i][1];
                int mDist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                pq.add(new Triplet(i, node, mDist));
            }
        }

        return sum;
    }

}
