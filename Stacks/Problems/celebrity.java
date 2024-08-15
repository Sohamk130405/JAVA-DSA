package Stacks.Problems;

import java.util.Stack;

public class celebrity {

    public static void main(String[] args) {

        int[][] arr = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
        // int[][] arr = { { 0, 1 }, { 1, 0 } };
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (arr[a][b] == 0)
                st.push(a);
            else if (arr[b][a] == 0)
                st.push(b);
        }

        if (st.size() == 0) {
            System.out.println(-1);
            return;
        }

        int potential = st.pop();
        for (int j = 0; j < arr.length; j++) {
            if (arr[potential][j] == 1) {
                System.out.println(-1);
                return;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == potential)
                continue;
            if (arr[i][potential] == 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(potential);
        return;

    }
}