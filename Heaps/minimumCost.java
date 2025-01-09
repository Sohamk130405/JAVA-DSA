package Heaps;
import java.util.PriorityQueue;
public class minimumCost {
    public static void main(String[] args) {
        int[] arr = {2,7,4,1,8};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele:arr) pq.add(ele);
        int sum = 0;
        while(pq.size()!=1){
            int y = pq.remove();
            int x = pq.remove();
            sum += x+y;
            pq.add(y+x); 
        }
        System.out.println(sum);  
    }
}
