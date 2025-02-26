package Graph.Dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int node;
    int dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(Pair p) {
        return this.dist - p.dist;
    }

}

public class DijkstraAlgo {

    public static void minDistance() {
        List<List<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] distance = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair top = pq.remove();
            int node = top.node;
            int dist = top.dist;
            for (Pair ele : adj.get(node)) {
                int totalDist = ele.dist + dist;
                if (totalDist < distance[ele.node]) {
                    pq.add(new Pair(ele.node, totalDist));
                    distance[ele.node] = totalDist;
                }
            }
        }
    }

}
