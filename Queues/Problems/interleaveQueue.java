package Queues.Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class interleaveQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        // Stack<Integer> qt = new Stack<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

        int n = q.size();
        while (q.size() != n / 2) {
            st.push(q.remove());
        }

        while (st.size() > 0) {
            q.add(st.pop());
        }

        while (q.size() != n / 2) {
            st.push(q.remove());
        }

        while (st.size() > 0) {
            q.add(st.pop());
            q.add(q.remove());
        }

        while (q.size() > 0) {
            st.push(q.remove());
        }
        while (st.size() > 0) {
            q.add(st.pop());
        }

        System.out.println(q);
    }
}
