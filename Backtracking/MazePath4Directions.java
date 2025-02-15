package Backtracking;

public class MazePath4Directions {
    public static void main(String[] args) {
        int m = 4, n = 4;
        boolean[][] isVisited = new boolean[m][n];
        System.out.println("Total ways: " + printPaths(0, 0, m - 1, n - 1, "", isVisited));
    }

    public static int printPaths(int i, int j, int m, int n, String s, boolean[][] isVisited) {
        if (i < 0 || j < 0 || i > m || j > n)
            return 0;
        if (isVisited[i][j])
            return 0;
        if (i == m && j == n) {
            System.out.println(s);
            return 1;
        }

        isVisited[i][j] = true;
        int right = printPaths(i, j + 1, m, n, s + "R", isVisited);
        int down = printPaths(i + 1, j, m, n, s + "D", isVisited);
        int left = printPaths(i, j - 1, m, n, s + "L", isVisited);
        int up = printPaths(i - 1, j, m, n, s + "U", isVisited);
        // backtracking
        isVisited[i][j] = false;
        return right + down + left + up;
    }

}


