package Queues.Basics;

import java.util.*;

@SuppressWarnings("unused")
public class basicSTL {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        System.out.println(q.isEmpty());
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        // System.out.println(q);
        // q.poll();
        // System.out.println(q);
        // q.remove();
        // System.out.println(q);
        // System.out.println(q.peek());
        // System.out.println(q.size());
        // System.out.println(q.isEmpty());

        int n = q.size();

        for (int i = 0; i < n; i++) {
            int x = q.poll();
            q.add(x);
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println(q);
    }
}
