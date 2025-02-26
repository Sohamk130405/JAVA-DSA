package Graph.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int node;
    int time;

    Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }

    @Override
    public int compareTo(Pair p) {
        return this.time - p.time;
    }

}

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] timing = new int[n + 1];
        Arrays.fill(timing, Integer.MAX_VALUE);
        timing[src] = 0;
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair top = pq.remove();
            int node = top.node;
            int time = top.time;
            if (time > timing[node])
                continue;
            else {
                for (Pair ele : adj.get(node)) {
                    int totalTime = ele.time + time;
                    if (totalTime < timing[ele.node]) {
                        pq.add(new Pair(ele.node, totalTime));
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
}
