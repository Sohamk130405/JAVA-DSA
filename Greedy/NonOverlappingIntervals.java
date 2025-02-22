package Greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int n = intervals.length;
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
            int cnt = 1;
            int i = 0, j = 1;
            while (j < n) {
                if (intervals[i][1] <= intervals[j][0]) {
                    i = j;
                    cnt++;
                }
                j++;
            }
            return n - cnt;
        }
    }
}
