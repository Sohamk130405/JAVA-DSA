
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class frequencySort {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 3, 2 };
        sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void sort(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int ele : map.keySet()) {
            int freq = map.get(ele);
            pq.add(new Pair(freq, ele));
        }
        int cnt = 0;
        while(pq.size()>0){
            Pair p = pq.remove();
            for (int i = 0; i < p.d; i++) {
                arr[cnt++] = p.x;
            }
        }

    }

}
