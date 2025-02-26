package Graph.Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

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

public class MinEffortsPath {
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

}
