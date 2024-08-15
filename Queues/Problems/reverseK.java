package Queues.Problems;

import java.util.*;

public class reverseK {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(q);

        int n = q.size();
        int k = 3;
        
        for (int i = 0; i < 3; i++) {
            st.push(q.poll());
        }
        for (int i = 0; i < 3; i++) {
            q.add(st.pop());
        }
        for (int i = 0; i < n-k; i++) {
            q.add(q.remove());
        }

        System.out.println(q);
    }
}
