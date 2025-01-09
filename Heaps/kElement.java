package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class kElement {
    public static void main(String[] args) {

        int[] arr = { 6, 4, 2, 7, 1, 3 };
        kthSmallestElement(arr, 3);

        int[] nearlySortedArrayOfK = { 6, 5, 3, 2, 8, 10, 9 };
        sortNearlySortedArrayOfK(nearlySortedArrayOfK, 3);

        int[] brr = { 7, 8, 18, 4, 9, 6 };

        kClosestElementsFromX(brr, 3, 8);

    }

    public static void kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Worst Method T.C = O(n+k(logn)) but best for finding
        // for (int i = 0; i < arr.length; i++) {
        // pq.add(arr[i]);
        // }
        // for (int i = 0; i < k - 1; i++) {
        // pq.remove();
        // }

        // Best Method T.C = O((2n-k)(logk)) = O(nlogk)
        for (int ele : arr) {
            pq.add(ele);
            if (pq.size() > k)
                pq.remove();
        }
        System.out.println(pq.peek());
    }

    public static void sortNearlySortedArrayOfK(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Best Method T.C = O(nlogk)
        int i = 0;
        for (int ele : arr) {
            pq.add(ele);
            if (pq.size() > k)
                arr[i++] = pq.remove();
        }
        while (pq.size() > 0) {
            arr[i++] = pq.remove();
        }
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static int[][] kClosestPointsToOrigin(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int d = x * x + y * y;
            pq.add(new Triplet(d, x, y));
            if (pq.size() > k) {
                pq.remove();
            }
        }

        for (int i = 0; i < k; i++) {
            Triplet t = pq.remove();
            ans[i][0] = t.x;
            ans[i][1] = t.y;
        }

        return ans;
    }

    public static List<Integer> kClosestElementsFromX(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int ele : arr) {
            int d = Math.abs(x - ele);
            pq.add(new Pair(d, ele));
            if (pq.size() > k) {
                pq.remove();
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Pair t = pq.remove();
            ans.add(t.x);
        }
        Collections.sort(ans);
        return ans;

    }

    public static int[] topKFrequentElements(int[] arr, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            int val = map.get(key);
            pq.add(new Pair(val,key));
            if (pq.size() > k)
                pq.remove();
        }
        for (int i = 0; i < k; i++) {
            Pair p = pq.remove();
            ans[i] = p.x;
        }
        return ans;
    }
}