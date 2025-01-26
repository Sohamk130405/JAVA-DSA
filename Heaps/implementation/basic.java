package implementation;

public class basic {
    public static void main(String[] args) {
        ArrayMinHeap pq = new ArrayMinHeap(11);
        pq.add(1);
        pq.add(2);
        pq.add(7);
        pq.add(3);
        pq.add(4);
        pq.add(20);
        pq.add(25);
        pq.add(13);
        pq.add(10);
        pq.add(14);
        pq.add(5);
        System.out.println(pq.top());
    }
}
