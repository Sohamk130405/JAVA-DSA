package Stacks.Basics;

import java.util.Stack;

public class reverseStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        reverseByRecursion(st);
        System.out.println(st);
    }

    public static void reverse(Stack<Integer> st) {
        Stack<Integer> qt = new Stack<>();
        Stack<Integer> rt = new Stack<>();
        while (st.size() > 0) {
            qt.push(st.pop());
        }
        while (qt.size() > 0) {
            rt.push(qt.pop());
        }
        while (rt.size() > 0) {
            st.push(rt.pop());
        }
    }

    public static void reverseByRecursion(Stack<Integer> st) {
        if (st.size() == 1) 
            return;
        int x = st.pop();
        reverseByRecursion(st);
        pushAtBottom(st, x);
    }

    public static void pushAtBottom(Stack<Integer> st, int val) {
        if (st.size() == 0) {
            st.push(val);
            return;
        }
        int x = st.pop();
        pushAtBottom(st, val);
        st.push(x);
    }
}
