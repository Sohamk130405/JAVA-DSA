package Stacks.Basics;

import java.util.Stack;

public class copyStack {

    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();


        st1.push(1);
        st1.push(2);
        st1.push(3);
        st1.push(4);
        st1.push(5);

        System.out.println("Stack: st1 = "+st1);
        while (st1.size() > 0) {
            st2.push(st1.pop());
        }
        System.out.println("Stack: st2 = "+st2);
        while (st2.size() > 0) {
            st3.push(st2.pop());
        }
        System.out.println("Stack: st3 = "+st3);

    }
}
