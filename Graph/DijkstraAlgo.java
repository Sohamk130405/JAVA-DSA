package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

class ProbPair implements Comparable<ProbPair> {
    int node;
    double pro;

    ProbPair(int node, double pro) {
        this.node = node;
        this.pro = pro;
    }

    @Override
    public int compareTo(ProbPair p) {
        return Double.compare(this.pro, p.pro);
    }

}

class Network implements Comparable<Network> {
    int node;
    int time;

    Network(int node, int time) {
        this.node = node;
        this.time = time;
    }

    @Override
    public int compareTo(Network p) {
        return this.time - p.time;
    }

}

class Triplet implements Comparable<Triplet> {
    int row;
    int col;
    int dist;

    Triplet(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }

    @Override
    public int compareTo(Triplet t) {
        return this.dist - t.dist;
    }
}

class FlightTriplet {
    int node;
    int cost;
    int stops;

    FlightTriplet(int node, int cost, int stops) {
        this.node = node;
        this.cost = cost;
        this.stops = stops;
    }
}

class Flight {
    int node;
    int cost;

    Flight(int node, int cost) {
        this.node = node;
        this.cost = cost;
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

    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Network>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            adj.get(time[0]).add(new Network(time[1], time[2]));
        }
        PriorityQueue<Network> pq = new PriorityQueue<>();
        int[] timing = new int[n + 1];
        Arrays.fill(timing, Integer.MAX_VALUE);
        timing[src] = 0;
        pq.add(new Network(src, 0));
        while (!pq.isEmpty()) {
            Network top = pq.remove();
            int node = top.node;
            int time = top.time;
            if (time > timing[node])
                continue;
            else {
                for (Network ele : adj.get(node)) {
                    int totalTime = ele.time + time;
                    if (totalTime < timing[ele.node]) {
                        pq.add(new Network(ele.node, totalTime));
                        timing[ele.node] = totalTime;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (timing[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, timing[i]);
        }
        return max;
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<ProbPair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new ProbPair(v, succProb[i]));
            adj.get(v).add(new ProbPair(u, succProb[i]));
        }
        PriorityQueue<ProbPair> pq = new PriorityQueue<>(Collections.reverseOrder());
        double[] probability = new double[n];
        probability[start] = 1;
        pq.add(new ProbPair(start, 1));
        while (!pq.isEmpty()) {
            ProbPair top = pq.remove();
            int node = top.node;
            double pro = top.pro;
            if (pro < probability[node])
                continue;
            else {
                for (ProbPair ele : adj.get(node)) {
                    double totalPro = ele.pro * pro;
                    if (totalPro > probability[ele.node]) {
                        pq.add(new ProbPair(ele.node, totalPro));
                        probability[ele.node] = totalPro;
                    }
                }
            }
        }
        return probability[end];
    }

    public int minimumEffortPath(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] efforts = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        efforts[0][0] = 0;
        pq.add(new Triplet(0, 0, 0));
        while (!pq.isEmpty()) {
            Triplet node = pq.remove();
            int row = node.row;
            int col = node.col;
            int dist = node.dist;
            int effort;
            if (row == m - 1 && col == n - 1)
                break;
            if (dist > efforts[row][col])
                continue;
            int r[] = { -1, 0, 1, 0 };
            int c[] = { 0, -1, 0, 1 };
            for (int i = 0; i <= 3; i++) {
                int newRow = row + r[i];
                int newCol = col + c[i];
                if (newRow < 0 || newCol < 0 || newRow > m - 1 || newCol > n - 1)
                    continue;
                effort = Math.max(dist, Math.abs(arr[row][col] - arr[newRow][newCol]));
                if (effort < efforts[newRow][newCol]) {
                    efforts[newRow][newCol] = effort;
                    pq.add(new Triplet(newRow, newCol, effort));
                }
            }
        }

        return efforts[m - 1][n - 1];
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Flight>> adj = new ArrayList<>();
        Queue<FlightTriplet> pq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];
            adj.get(from).add(new Flight(to, cost));
        }

        int[] costs = new int[adj.size()];
        Arrays.fill(costs, Integer.MAX_VALUE);

        costs[src] = 0;
        pq.add(new FlightTriplet(src, 0, 0));

        while (!pq.isEmpty()) {
            FlightTriplet top = pq.remove();
            int node = top.node;
            int cost = top.cost;
            int stops = top.stops;
            if (stops == k + 1)
                continue;
            for (Flight ele : adj.get(node)) {
                int totalCost = ele.cost + cost;
                if (totalCost < costs[ele.node]) {
                    pq.add(new FlightTriplet(ele.node, totalCost, stops + 1));
                    costs[ele.node] = totalCost;
                }
            }
        }
        if (costs[dst] == Integer.MAX_VALUE)
            return -1;
        return costs[dst];
    }
}
