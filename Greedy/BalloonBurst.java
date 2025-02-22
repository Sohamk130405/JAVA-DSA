package Greedy;

import java.util.Arrays;

public class BalloonBurst {
    class Solution {
        public int findMinArrowShots(int[][] points) {
            int n = points.length;
            if (n == 0)
                return 0;
            Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
            int cnt = 1;
            int i = 0, j = 1;
            while (j < n) {
                if (points[i][1] < points[j][0]) {
                    i = j;
                    cnt++;
                }
                j++;
            }
            return cnt;
        }
    }
}
