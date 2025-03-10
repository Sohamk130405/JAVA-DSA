package Backtracking;

public class MaximumKnights {
    static int max = 0;

    public static void main(String[] args) {
        System.out.println(maxKnights(5));
    }

    public static int maxKnights(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        count(board, 0, 0, 0);
        return max;
    }

    public static void count(char[][] board, int row, int col, int num) {
        int n = board.length;
        if (row == n) {
            max = Math.max(max, num);
            return;
        } else if (isSafe(board, row, col)) {
            board[row][col] = 'K';
            if (col != n - 1)
                count(board, row, col + 1, num + 1);
            else
                count(board, row + 1, 0, num + 1);
            board[row][col] = 'X';
        }

        else { // for all possible combination put it outside else
            if (col != n - 1)
                count(board, row, col + 1, num);
            else
                count(board, row + 1, 0, num);
        }

    }

    public static void display(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        int i, j;
        // 2 up 1 right
        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < n && board[i][j] == 'K')
            return false;

        // 2 up 1 left
        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && board[i][j] == 'K')
            return false;

        // 2 down 1 right
        i = row + 2;
        j = col + 1;
        if (i < n && j < n && board[i][j] == 'K')
            return false;

        // 2 down 1 left
        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && board[i][j] == 'K')
            return false;

        // 2 right 1 up
        j = col + 2;
        i = row - 1;
        if (i >= 0 && j < n && board[i][j] == 'K')
            return false;

        // 2 right 1 down
        j = col + 2;
        i = row + 1;
        if (i < n && j < n && board[i][j] == 'K')
            return false;

        // 2 left 1 up
        j = col - 2;
        i = row - 1;
        if (i >= 0 && j >= 0 && board[i][j] == 'K')
            return false;

        // 2 left 1 down
        j = col - 2;
        i = row + 1;
        if (i < n && j >= 0 && board[i][j] == 'K')
            return false;

        return true;
    }
}
