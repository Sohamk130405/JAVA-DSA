package BitManupulation;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int total = 1 << n;
        for (int num = 0; num < total; num++) {
            List<Integer> al = new ArrayList<>();
            for (int bitIdx = 0; bitIdx < n; bitIdx++) {
                if ((num & (1 << bitIdx)) != 0) {
                    al.add(nums[bitIdx]);
                }
            }
            ans.add(al);
        }
        return ans;
    }

}
