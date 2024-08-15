package Stacks.Problems;

import java.util.Stack;

public class nextGreaterElement {
    public static void main(String[] args) {
        int[] arr = { 100, 110, 60, 70, 60, 70, 75, 85 };
        int[] res = nextGreaterElementByStack(arr);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] nextGreaterElementByStack(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        res[n - 1] = -1;
        st.push(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {

            while (st.size() > 0 && st.peek() < arr[i]) {
                st.pop();
            }
            if (st.size() == 0)
                res[i] = -1;
            else
                res[i] = st.peek();
            st.push(arr[i]);

        }

        return res;
    }

    public static int[] nextGreaterElementByArray(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = arr[j];
                    break;
                }
            }
        }

        return res;
    }

}