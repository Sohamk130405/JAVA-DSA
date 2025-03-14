package Backtracking;

public class KnightTourConfiguration {
    public static void main(String[] args) {

    }

    public static boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0)
            return false;
        return check(grid, 0, 0, 0);
    }

    private static boolean check(int[][] grid, int row, int col, int num) {
        int n = grid.length;
        if (grid[row][col] == n * n - 1)
            return true;
        int i, j;
        // 2 up 1 right
        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < n && grid[i][j] == num + 1)
            return check(grid, i, j, num + 1);

        // 2 up 1 left
        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1)
            return check(grid, i, j, num + 1);

        // 2 down 1 right
        i = row + 2;
        j = col + 1;
        if (i < n && j < n && grid[i][j] == num + 1)
            return check(grid, i, j, num + 1);

        // 2 down 1 left
        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && grid[i][j] == num + 1)
            return check(grid, i, j, num + 1);

        // 2 right 1 up
        j = col + 2;
        i = row - 1;
        if (i >= 0 && j < n && grid[i][j] == num + 1)
            return check(grid, i, j, num + 1);

        // 2 right 1 down
        j = col + 2;
        i = row + 1;
        if (i < n && j < n && grid[i][j] == num + 1)
            return check(grid, i, j, num + 1);

        // 2 left 1 up
        j = col - 2;
        i = row - 1;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1)
            return check(grid, i, j, num + 1);

        // 2 left 1 down
        j = col - 2;
        i = row + 1;
        if (i < n && j >= 0 && grid[i][j] == num + 1)
            return check(grid, i, j, num + 1);

        return false;
    }

}
