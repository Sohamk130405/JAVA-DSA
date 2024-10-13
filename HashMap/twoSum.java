package HashMap;

import java.util.HashMap;

// O(n)
public class twoSum {
    public int[] main(int[] arr, int target) {
        int[] ans = { -1, -1 };
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                ans[0] = i;
                ans[1] = map.get(diff);
                return ans;
            } else {
                map.put(arr[i], i);
            }
        }
        return ans;
    }
}
