package Backtracking;

public class ValidSudoku {
    public static void main(String[] args) {

    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.')
                    continue;
                board[i][j] = '.';
                if (!isValid(board, i, j, ch))
                    return false;
                board[i][j] = ch;
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, char num) {
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
