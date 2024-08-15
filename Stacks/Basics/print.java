package Stacks.Basics;

import java.util.Stack;

public class print {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        printByRecursion(st);
        System.out.println();
        printReverseByRecursion(st);

        System.out.println();
        System.out.println(st);

    }

    public static void printByStack(Stack<Integer> st) {
        Stack<Integer> rt = new Stack<>();
        while (st.size() > 0) {
            rt.push(st.pop());
        }

        while (rt.size() > 0) {
            int x = rt.pop();
            System.out.print(x + " ");
            st.push(x);
        }
    }

    public static void printByArray(Stack<Integer> st) {
        int n = st.size();
        int arr[] = new int[n];
        int i = n - 1;
        while (st.size() > 0) {
            arr[i--] = st.pop();
        }
        i = 0;
        while (i < n) {
            st.push(arr[i++]);
            System.out.print(st.peek() + " ");
        }
    }

    public static void printByRecursion(Stack<Integer> st) {
        if (st.size() == 0)
            return;
        int x = st.pop();
        printByRecursion(st);
        System.out.print(x + " ");
        st.push(x);
    }

    public static void printReverseByRecursion(Stack<Integer> st) {
        if (st.size() == 0)
            return;
        int x = st.pop();
        System.out.print(x + " ");
        printReverseByRecursion(st);
        st.push(x);
    }
}
