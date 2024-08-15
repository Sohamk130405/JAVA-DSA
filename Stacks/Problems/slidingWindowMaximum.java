package Stacks.Problems;

import java.util.Stack;

public class slidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int n = arr.length;

        int[] next = new int[n];
        nextGreator(arr, next);
        int[] ans = new int[n - k + 1];
        int z = 0;

        int j = 0;
        for (int i = 0; i < n - k + 1; i++) {
            if (j >= i + k)
                j = i;
            int max = arr[j];
            while (j < i + k) {
                max = arr[j];
                j = next[j];
            }
            ans[z++] = max;
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }

    public static void nextGreator(int[] arr, int[] next) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

}
