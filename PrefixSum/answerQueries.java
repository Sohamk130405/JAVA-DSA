package PrefixSum;

import java.util.Arrays;

public class answerQueries {
    
}

class Solution {
    public int[] answerQueries(int[] arr, int[] queries) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++)
            arr[i] += arr[i - 1];
        for (int i = 0; i < queries.length; i++) {
            int len = 0;
            int hi = arr.length - 1;
            int lo = 0;
            while (lo <= hi) {
                int mid = (hi - lo) / 2 + lo;
                if (queries[i] < arr[mid])
                    hi = mid - 1;
                else {
                    len = Math.max(len, mid + 1);
                    lo = mid + 1;
                }
            }
            queries[i] = len;
        }
        return queries;

    }
}