package Stacks.Problems;

import java.util.Stack;

// similar to next greater element --> instead find previous greatest element freq
public class stockSpan {

    public static void main(String[] args) {
        int[] arr = { 100, 110, 60, 70, 60, 70, 75, 85 };
        int[] res = spanOfPreviousGreaterElement(arr);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] spanOfPreviousGreaterElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        res[0] = 1;
        st.push(0);
        for (int i = 1; i < n; i++) {

            while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (st.size() == 0)
                res[i] = i + 1;
            else
                res[i] = i - st.peek();
            st.push(i);
        }
        return res;
    }
}