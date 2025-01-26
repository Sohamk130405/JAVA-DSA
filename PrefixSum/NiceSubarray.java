package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class NiceSubarray {
    class Solution {
        public int numberOfSubarrays(int[] arr, int k) {
            int cnt = 0, n = arr.length;
            for (int i = 0; i < n; i++)
                arr[i] %= 2;
            for (int i = 1; i < n; i++)
                arr[i] += arr[i - 1];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!map.containsKey(arr[i]))
                    map.put(arr[i], i);
                int a = map.getOrDefault(arr[i] - k, 0);
                int b = map.getOrDefault(arr[i] - k + 1, 0);
                if (arr[i] == k)
                    cnt += (b - a + 1);
                if (arr[i] > k)
                    cnt += (b - a);
            }
            return cnt;
        }
    }
}
