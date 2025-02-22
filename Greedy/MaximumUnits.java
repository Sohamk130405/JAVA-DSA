package Greedy;

import java.util.Arrays;

public class MaximumUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int res = 0;
        for (int[] arr : boxTypes) {
            if (truckSize > arr[0]) {
                res += arr[0] * arr[1];
            } else {
                res += (truckSize * arr[1]);
                break;
            }
            truckSize -= arr[0];
        }

        return res;
    }
}
