import java.util.Scanner;

public class basics {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[2][3];
        int[][] brr = { { 1, 2, 3 }, { 4, 5, 6 } };

        System.out.println("Enter Array elements for your array: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // printing using for-loop
        System.out.println("Predefined Array elements");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(brr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Your Array elements");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        // printing using for-each-loop
        System.out.println("Predefined Array elements");
        for (int[] x : brr) {
            for (int a : x) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println("Added  Array elements");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] += brr[i][j];
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
