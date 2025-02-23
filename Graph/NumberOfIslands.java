package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!isVisited[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j, isVisited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void bfs(char[][] grid, int i, int j, boolean[][] isVisited) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        isVisited[i][j] = true;

        while (!q.isEmpty()) {
            Pair node = q.remove();
            int row = node.row;
            int col = node.col;
            if (row < n - 1 && !isVisited[row + 1][col] && grid[row + 1][col] == '1') {
                q.add(new Pair(row + 1, col));
                isVisited[row + 1][col] = true;
            }
            if (col < m - 1 && !isVisited[row][col + 1] && grid[row][col + 1] == '1') {
                q.add(new Pair(row, col + 1));
                isVisited[row][col + 1] = true;
            }
            if (row > 0 && !isVisited[row - 1][col] && grid[row - 1][col] == '1') {
                q.add(new Pair(row - 1, col));
                isVisited[row - 1][col] = true;
            }
            if (col > 0 && !isVisited[row][col - 1] && grid[row][col - 1] == '1') {
                q.add(new Pair(row, col - 1));
                isVisited[row][col - 1] = true;
            }
        }
    }
}