package Stacks.Basics;

import java.util.Scanner;
import java.util.Stack;

public class basic {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st1 = new Stack<>();
        st.push(1);
        st.push(23);
        st.push(6);
        System.out.println(st); 
        System.out.println(st.peek());
        st.pop();
        System.out.println(st);


        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            st1.push(sc.nextInt());
        }

        System.out.println(st1);

    } 
}
