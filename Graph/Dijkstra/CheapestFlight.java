package Graph.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Triplet {
    int node;
    int cost;
    int stops;

    Triplet(int node, int cost, int stops) {
        this.node = node;
        this.cost = cost;
        this.stops = stops;
    }
}

class Pair {
    int node;
    int cost;

    Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

public class CheapestFlight {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        Queue<Triplet> pq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];
            adj.get(from).add(new Pair(to, cost));
        }

        int[] costs = new int[adj.size()];
        Arrays.fill(costs, Integer.MAX_VALUE);

        costs[src] = 0;
        pq.add(new Triplet(src, 0, 0));

        while (!pq.isEmpty()) {
            Triplet top = pq.remove();
            int node = top.node;
            int cost = top.cost;
            int stops = top.stops;
            if (stops == k + 1)
                continue;
            for (Pair ele : adj.get(node)) {
                int totalCost = ele.cost + cost;
                if (totalCost < costs[ele.node]) {
                    pq.add(new Triplet(ele.node, totalCost, stops + 1));
                    costs[ele.node] = totalCost;
                }
            }
        }
        if (costs[dst] == Integer.MAX_VALUE)
            return -1;
        return costs[dst];
    }
}
