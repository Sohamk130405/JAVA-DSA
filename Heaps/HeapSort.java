
import java.util.PriorityQueue;

class HeapSort {
    public void Sort(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int ele : arr) {
            pq.add(ele);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = pq.remove();
        }
    }
}