package Stacks.Basics;

import java.util.Stack;

public class remove {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        removeByRecursion(st, 4);
        System.out.println(st);
    }

    public static void removeByRecursion(Stack<Integer> st, int idx) {
        if (st.size() - 1 == idx) {
            st.pop();
            return;
        }
        int x = st.pop();
        removeByRecursion(st, idx);
        st.push(x);
    }
}
