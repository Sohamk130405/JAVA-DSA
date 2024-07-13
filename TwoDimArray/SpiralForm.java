public class SpiralForm {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 12 }, { 4, 5, 6, 11 }, { 7, 8, 9, 10 } };
        int maxr = arr.length - 1;
        int minr = 0;
        int maxc = arr[0].length - 1;
        int minc = 0;
        for (int i = 0; i <= maxr; i++) {
            for (int j = 0; j <= maxc; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        while (minr <= maxr && maxc >= minc) {
            for (int j = minc; j <= maxc; j++) {
                System.out.print(arr[minr][j] + " ");
            }
            if (minr > maxr || maxc < minc)
                break;
            minr++;
            for (int j = minr; j <= maxr; j++) {
                System.out.print(arr[j][maxc] + " ");
            }
            if (minr > maxr || maxc < minc)
                break;
            maxc--;
            for (int j = maxc; j >= minc; j--) {
                System.out.print(arr[maxr][j] + " ");
            }
            if (minr > maxr || maxc < minc)
                break;
            maxr--;
            for (int j = maxr; j >= minr; j--) {
                System.out.print(arr[j][minc] + " ");
            }
            minc++;
        }
    }
}
