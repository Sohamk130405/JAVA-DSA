package Stacks.Basics;

import java.util.Stack;

public class insertion {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        insertByRecursion(st, 0,3);
        System.out.println(st);
    }

    public static void insertByStack(Stack<Integer> st, int idx, int val) {
        Stack<Integer> rt = new Stack<>();
        while (st.size() > idx) {
            rt.push(st.pop());
        }
        st.push(val);
        while (rt.size() > 0) {
            st.push(rt.pop());
        }
    }

    public static void insertByRecursion(Stack<Integer> st, int idx, int val) {
        if (st.size() == idx) {
            st.push(val);
            return;
        }
        int x = st.pop();
        insertByRecursion(st, idx, val);
        st.push(x);
    }

}
