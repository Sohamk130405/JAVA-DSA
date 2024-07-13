public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } };
        int m = arr.length;
        int n = arr[0].length;

        // O(m*n)
        // int[][] helper = new int[m][n];

        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // helper[i][j] = arr[i][j];
        // }
        // }

        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (helper[i][j] == 0) {
        // // set ith row and jth column to zero
        // for (int j2 = 0; j2 < n; j2++) {
        // arr[i][j2] = 0;
        // }
        // for (int j2 = 0; j2 < m; j2++) {
        // arr[j2][j] = 0;
        // }
        // }
        // }
        // }

        // O(m+n)
        // boolean[] row = new boolean[m];
        // boolean[] col = new boolean[n];
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (arr[i][j] == 0) {
        // row[i] = true;
        // col[j] = true;
        // }
        // }
        // }

        // for (int i = 0; i < m; i++) {
        // if (row[i] == true) {
        // for (int j2 = 0; j2 < n; j2++) {
        // arr[i][j2] = 0;
        // }
        // }
        // }
        // for (int i = 0; i < n; i++) {
        // if (col[i] == true) {
        // for (int j2 = 0; j2 < m; j2++) {
        // arr[j2][i] = 0;
        // }
        // }
        // }
        boolean zeroRow = false;
        boolean zeroColumn = false;
        // Check if the first row contains zero
        for (int i = 0; i < n; i++) {
            if (arr[0][i] == 0) {
                zeroRow = true;
                break;
            }
        }

        // Check if the first column contains zero
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 0) {
                zeroColumn = true;
                break;
            }
        }

        // Mark zeros on first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        // Set zeros based on marks in the first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        // Set first row to zero if necessary
        if (zeroRow) {
            for (int i = 0; i < n; i++) {
                arr[0][i] = 0;
            }
        }

        // Set first column to zero if necessary
        if (zeroColumn) {
            for (int i = 0; i < m; i++) {
                arr[i][0] = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
