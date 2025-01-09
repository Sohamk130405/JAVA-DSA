package Heaps.implementation;

public class basic {
    public static void main(String[] args) {
        ArrayHeap pq = new ArrayHeap(5);
        pq.add(3);
        pq.add(10);
        pq.add(7);
        pq.add(2);
        pq.add(8);
        System.out.println(pq.size());
        System.out.println(pq.remove());
        System.out.println(pq.top());
    }
}
