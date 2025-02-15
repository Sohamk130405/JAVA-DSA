package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        solveNQueens(4);
    }

    public static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        nqueens(board, 0);
    }

    public static void nqueens(char[][] board, int row) {
        if (row == board.length) {
            display(board);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nqueens(board, row + 1);
                board[row][j] = 'X';
            }
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
        // check row and cols
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q' || board[i][col] == 'Q')
                return false;
        }
        // check diagonals
        int i = row;
        int j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        i = row;
        j = col;
        while (i < n && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j++;
        }
        i = row;
        j = col;
        while (i < n && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j--;
        }
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        return true;
    }

}
// NQueens 1
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nqueens(board, 0, ans);
        return ans;
    }

    public void nqueens(char[][] board, int row, List<List<String>> ans) {
        int n = board.length;
        if (row == n) {
            List<String> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < n; j++) {
                    str += board[i][j];
                }
                al.add(str);
            }
            ans.add(al);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nqueens(board, row + 1, ans);
                board[row][j] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        // check row and cols
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q' || board[i][col] == 'Q')
                return false;
        }
        // check diagonals
        int i = row;
        int j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        i = row;
        j = col;
        while (i < n && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j++;
        }
        i = row;
        j = col;
        while (i < n && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j--;
        }
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        return true;
    }

}