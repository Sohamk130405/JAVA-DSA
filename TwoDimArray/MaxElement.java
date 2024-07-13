public class MaxElement {
    public static void main(String[] args) {
        int[][] arr = { { 3, 4, 12 }, { 3, 6, 8 } };
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (max < arr[i][j])
                    max = arr[i][j];
            }
        }
        System.out.println(max);
    }
}
