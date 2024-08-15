package Queues.Basics;

import java.util.*;


public class deque {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addLast(2);
        dq.add(3);
        dq.addFirst(4);
        dq.addLast(5);
        dq.add(6);
        System.out.println(dq);
    }
}
