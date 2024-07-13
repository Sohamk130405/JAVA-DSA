public class WaveForm {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int n = arr.length;
        // printing using for-loop
        System.out.println("Row Waveform ");
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }

        }
        System.out.println();
        System.out.println("Column Waveform ");
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[j][i] + " ");
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    System.out.print(arr[j][i] + " ");
                }
            }

        }
    }
}
