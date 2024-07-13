public class ScoreAfterFlippingMatrix {

    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 0, 1 }, { 0, 1, 0, 1 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 } };
        int m = arr.length, n = arr[0].length;
        int score = 0;
        printArray(arr, m, n);
        System.out.println(calculateScore(arr));
        System.out.println();

        /*
         * // less effective solution
         * for (int i = 0; i < m; i++) {
         * // put 1 at the 0th position
         * if (arr[i][0] == 0) {
         * for (int j = 0; j < n; j++) {
         * if (arr[i][j] == 0)
         * arr[i][j] = 1;
         * else
         * arr[i][j] = 0;
         * }
         * printArray(arr, m, n);
         * if (score < calculateScore(arr)) {
         * score = calculateScore(arr);
         * }
         * System.out.println(calculateScore(arr));
         * i = 0;
         * } else {
         * // flip the columns containing 0
         * for (int j = 0; j < n; j++) {
         * if (arr[i][j] == 0) {
         * int cnt1 = 0;
         * int cnt0 = 0;
         * for (int k = 0; k < m; k++) {
         * if (arr[k][j] == 0)
         * cnt0++;
         * else
         * cnt1++;
         * }
         * if (cnt1 < cnt0) {
         * for (int k = 0; k < m; k++) {
         * if (arr[k][j] == 0)
         * arr[k][j] = 1;
         * else
         * arr[k][j] = 0;
         * }
         * }
         * printArray(arr, m, n);
         * if (score < calculateScore(arr)) {
         * score = calculateScore(arr);
         * }
         * System.out.println(calculateScore(arr));
         * }
         * 
         * }
         * }
         * }
         */

        // put 1 at the 0th position of every row
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0)
                        arr[i][j] = 1;
                    else
                        arr[i][j] = 0;
                }
                if (score < calculateScore(arr)) {
                    score = calculateScore(arr);
                }
            }
        }
        // flip those columns where no. of zeores are more than ones
        for (int i = 1; i < n; i++) {
            int noOfZeroes = 0, noOfOnes = 0;
            for (int j = 0; j < m; j++) {
                if (arr[j][i] == 0)
                    noOfZeroes++;
                else
                    noOfOnes++;
            }
            // flip that column
            if (noOfZeroes > noOfOnes) {
                for (int j = 0; j < m; j++) {
                    if (arr[j][i] == 0)
                        arr[j][i] = 1;
                    else
                        arr[j][i] = 0;
                }
                if (score < calculateScore(arr)) {
                    score = calculateScore(arr);
                }
            }
        }

        System.out.println();
        System.out.println();
        System.out.println(score);
    }

    private static void printArray(int[][] arr, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int calculateScore(int[][] arr) {
        int score = 0;
        int x = 1;
        for (int i = arr[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < arr.length; j++) {
                score += arr[j][i] * x;
            }
            x *= 2;
        }
        // this is for time optimization or use Math.pow() for better memory
        // optimization
        return score;
    }
}
