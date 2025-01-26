import java.util.List;
import java.util.PriorityQueue;

class TripletRowColEle implements Comparable<TripletRowColEle> {
    int ele;
    int row;
    int col;

    TripletRowColEle(int ele, int row, int col) {
        this.ele = ele;
        this.col = col;
        this.row = row;
    }

    @Override
    public int compareTo(TripletRowColEle t) {
        return this.ele - t.ele;
    }

}

public class Range {

    public int[] smallestRange(List<List<Integer>> nums) {
        int[] ans = { 0, Integer.MAX_VALUE };
        PriorityQueue<TripletRowColEle> pq = new PriorityQueue<>();
        int k = nums.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int ele = nums.get(i).get(0);
            pq.add(new TripletRowColEle(ele, i, 0));
            max = Math.max(max, ele);
        }

        while (true) {
            TripletRowColEle top = pq.remove();
            int ele = top.ele, row = top.row, col = top.col;

            if (max - ele < ans[1] - ans[0]) {
                ans[0] = ele;
                ans[1] = max;
            }
            if (col == nums.get(row).size() - 1)
                break;
            int nextEle = nums.get(row).get(col + 1);
            max = Math.max(max, nextEle);
            pq.add(new TripletRowColEle(nextEle, row, col + 1));
        }

        return ans;
    }
}
