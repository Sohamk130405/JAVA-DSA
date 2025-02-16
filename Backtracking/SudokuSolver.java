package Backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = new char[9][9];
        char[][] grid = new char[9][9];
        solve(board, 0, 0, grid);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = grid[i][j];
            }
        }
    }

    public static void solve(char[][] board, int row, int col, char[][] grid) {
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid[i][j] = board[i][j];
                }
            }
            return;
        }
        char ch = board[row][col];
        if (ch != '.') {
            if (col != 8)
                solve(board, row, col + 1, grid);
            else
                solve(board, row + 1, 0, grid);
        } else {
            for (char i = '1'; i <= '9'; i++) {
                if (ValidSudoku.isValid(board, row, col, i)) {
                    board[row][col] = i;
                    if (col != 8)
                        solve(board, row, col + 1, grid);
                    else
                        solve(board, row + 1, 0, grid);
                    board[row][col] = '.';
                }
            }
        }
    }
}

class Solution {
    static boolean flag = false;

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
        flag = false;
    }

    public void solve(char[][] board, int row, int col) {
        if (row == 9) {
            flag = true;
            return;
        }
        char ch = board[row][col];
        if (ch != '.') {
            if (col != 8)
                solve(board, row, col + 1);
            else
                solve(board, row + 1, 0);
        } else {
            for (char i = '1'; i <= '9'; i++) {
                if (isValid(board, row, col, i)) {
                    board[row][col] = i;
                    if (col != 8)
                        solve(board, row, col + 1);
                    else
                        solve(board, row + 1, 0);
                    if (flag)
                        return;
                    board[row][col] = '.';
                }
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col, char num) {
        // check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num)
                return false;
        }
        // check col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num)
                return false;
        }
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}