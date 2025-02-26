package Graph.Dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int node;
    double pro;

    Pair(int node, double pro) {
        this.node = node;
        this.pro = pro;
    }

    @Override
    public int compareTo(Pair p) {
        return Double.compare(this.pro, p.pro);
    }

}

public class MaxProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new Pair(v, succProb[i]));
            adj.get(v).add(new Pair(u, succProb[i]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        double[] probability = new double[n];
        probability[start] = 1;
        pq.add(new Pair(start, 1));
        while (!pq.isEmpty()) {
            Pair top = pq.remove();
            int node = top.node;
            double pro = top.pro;
            if (pro < probability[node])
                continue;
            else {
                for (Pair ele : adj.get(node)) {
                    double totalPro = ele.pro * pro;
                    if (totalPro > probability[ele.node]) {
                        pq.add(new Pair(ele.node, totalPro));
                        probability[ele.node] = totalPro;
                    }
                }
            }
        }
        return probability[end];
    }

}
