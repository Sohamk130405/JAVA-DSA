import java.util.Scanner;

public class multiplicationOfTwoMatrices {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and column of matrix 1 : ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        System.out.print("Enter elements of matrix 1: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter rows and column of matrix 2 : ");
        int p = sc.nextInt();
        int q = sc.nextInt();

        if (n != p) {
            System.out.println("Number of columns of matrix 1 must same as number of rows of matrix 2");
        } else {
            int[][] brr = new int[p][q];
            System.out.println("Enter elements of matrix 2: ");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    brr[i][j] = sc.nextInt();
                }
            }

            int[][] crr = new int[m][q];

            System.out.println("Matrix1 x Matrix2 = ");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < q; j++) {
                    for (int k = 0; k <= j; k++) {
                        crr[i][j] += arr[i][k] * brr[j][k];
                    }
                    System.out.print(crr[i][j] + " ");
                }
                System.out.println();
            }

        }

    }
}
