public class Transpose {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // printing using for-loop
        System.out.println("Print Array ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        // printing using for-loop
        System.out.println("Print Array Transpose");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i < j) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Array Rotation by 90 degree clockwise");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 / 2 + 1; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][2 - j];
                arr[i][2 - j] = temp;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
