import java.util.ArrayList;
import java.util.List;

public class TwoDimArrayList {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        @SuppressWarnings("unused")
        List<List<Integer>> v = new ArrayList<>(); // empty list
        List<List<Integer>> u = new ArrayList<>(m); // m size list
        for (int i = 0; i < m; i++) {
            u.add(new ArrayList<>(n)); // m x n array list
        }
        int count = 1;
        // adding elements in 2d ArrayList
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                u.get(i).add(count++);  
            }
        }
        // printing 2d ArrayList
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(u.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
