
import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int maxr = arr.length - 1;
        int minr = 0;
        int maxc = arr[0].length - 1;
        int minc = 0;
        int count = 1;

        while (minr <= maxr && maxc >= minc) {
            for (int j = minc; j <= maxc; j++) {
                (arr[minr][j]) = count++;
            }
            if (minr > maxr || maxc < minc)
                break;
            minr++;
            for (int j = minr; j <= maxr; j++) {
                (arr[j][maxc]) = count++;
            }
            if (minr > maxr || maxc < minc)
                break;
            maxc--;
            for (int j = maxc; j >= minc; j--) {
                (arr[maxr][j]) = count++;
            }
            if (minr > maxr || maxc < minc)
                break;
            maxr--;
            for (int j = maxr; j >= minr; j--) {
                (arr[j][minc]) = count++;
            }
            minc++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

    }
}
