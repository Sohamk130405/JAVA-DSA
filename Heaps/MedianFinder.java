
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
import java.util.Collections;
import java.util.PriorityQueue;

// Best Case T.C = O(nlogn)
class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.size() == 0)
            maxHeap.add(num);
        else {
            if (num < maxHeap.peek())
                maxHeap.add(num);
            else
                minHeap.add(num);
        }

        if (maxHeap.size() == minHeap.size() + 2)
            minHeap.add(maxHeap.remove());
        if (minHeap.size() == maxHeap.size() + 2)
            maxHeap.add(minHeap.remove());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return minHeap.peek();
    }

}

/*
 * // Using Collections.sort(list) T.C ~ O(n^2logn)
 * class MedianFinder {
 * List<Integer> list;
 * 
 * public MedianFinder() {
 * list = new ArrayList<>();
 * }
 * 
 * public void addNum(int num) {
 * list.add(num);
 * }
 * 
 * public double findMedian() {
 * Collections.sort(list);
 * int n = list.size();
 * if (n % 2 != 0)
 * return list.get(n / 2);
 * return (list.get(n / 2) + list.get(n / 2 - 1)) / 2.0;
 * }
 * }
 */

/*
 * // Using insertion sort T.C ~ O(n^2)
 * class MedianFinder {
 * List<Integer> list;
 * 
 * public MedianFinder() {
 * list = new ArrayList<>();
 * }
 * 
 * public void addNum(int num) {
 * list.add(num);
 * int i = list.size() - 1;
 * while (i > 0) {
 * if (list.get(i) < list.get(i - 1))
 * swap(i, i - 1);
 * else
 * break;
 * }
 * }
 * 
 * public double findMedian() {
 * int n = list.size();
 * if (n % 2 != 0)
 * return list.get(n / 2);
 * return (list.get(n / 2) + list.get(n / 2 - 1)) / 2.0;
 * }
 * 
 * public void swap(int i, int j) {
 * int temp = list.get(i);
 * list.set(i, j);
 * list.set(j, temp);
 * }
 * }
 */