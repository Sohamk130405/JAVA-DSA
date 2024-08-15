package Stacks.Problems;

import java.util.Stack;

public class removeConsecutiveSubsequences {
    public static void main(String[] args) {
        int[] arr = { 1,1,1, 2, 2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7,2 };
        int[] res = remove(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] remove(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            if ( st.size()!=0 && st.peek() == num)
                st.pop(); 
            else if ( num != arr[i - 1]) st.push(num); 
        }

        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;

    }
}