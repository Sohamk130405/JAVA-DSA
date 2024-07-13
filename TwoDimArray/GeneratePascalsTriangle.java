import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneratePascalsTriangle {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> pasTri = new ArrayList<>(n);
        // using factorial method
        // for (int i = 0; i < n; i++) {
        // List<Integer> l = new ArrayList<>(i + 1);
        // for (int j = 0; j < i + 1; j++) {
        // l.add(combination(i, j));
        // }
        // pasTri.add(l);
        // }

        // without factorial
        // for (int i = 0; i < n; i++) {
        // List<Integer> l = new ArrayList<>(i + 1);
        // for (int j = 0; j < i + 1; j++) {
        // l.add(1);
        // }
        // pasTri.add(l);
        // }
        // for (int i = 2; i < n; i++) {
        // for (int j = 1; j < i; j++) {
        // pasTri.get(i).set(j, pasTri.get(i - 1).get(j) + pasTri.get(i - 1).get(j -
        // 1));
        // }

        // }

        // more efficient
        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i)
                    l.add(1);
                else
                    l.add(pasTri.get(i - 1).get(j) + pasTri.get(i - 1).get(j - 1));
            }
            pasTri.add(l);

        }
        System.out.println(pasTri);

    }

    @SuppressWarnings("unused")
    private static int combination(int n, int r) {
        return factorial(n) / (factorial(n - r) * factorial(r));
    }

    private static int factorial(int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return 1;
        return factorial(n - 1) * n;
    }
}
