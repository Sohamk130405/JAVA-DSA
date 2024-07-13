public class Rotaion {
    public static void main(String[] args) {

        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int n = arr.length;
        // printing using for-loop
        System.out.println("Print Array ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;

                }

            }

        }
        // rotate
        System.out.println("Array Rotation by 90 degree clockwise");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n % 2 == 0 ? n / 2 : n / 2 + 1); j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][n - 1 - j];
                arr[i][n - 1 - j] = temp;

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
