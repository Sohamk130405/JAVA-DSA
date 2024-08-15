package Stacks.Problems;

import java.util.Stack;

public class largestAreaOfHistogram {
    public static void main(String[] args) {
        int[] arr = { 1,1 };
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int[] prev = new int[n];
        int[] next = new int[n];
        prevSmallest(arr, prev);
        nextSmallest(arr, next);
        for (int i = 0; i < arr.length; i++) {
            int width = next[i] - prev[i] -1;
            int area = width * arr[i];
            max = Math.max(max, area);

        }

        System.out.println(max);

    }

    public static void prevSmallest(int[] arr, int[] prev) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    public static void nextSmallest(int[] arr, int[] next) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

}
