package Heaps;

import java.util.PriorityQueue;

public class basic {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(10);
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);
    }
}
