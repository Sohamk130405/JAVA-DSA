package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] arr) {
            List<int[]> res = new ArrayList<>();
            Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
            int start = arr[0][0], prevEnd = arr[0][1];

            for (int i = 1; i < arr.length; i++) {
                if (arr[i][0] <= prevEnd) {
                    prevEnd = Math.max(prevEnd, arr[i][1]);
                } else {
                    res.add(new int[] { start, prevEnd });
                    start = arr[i][0];
                    prevEnd = arr[i][1];
                }
            }
            res.add(new int[] { start, prevEnd });

            return res.toArray(new int[res.size()][2]);
        }
    }
}
