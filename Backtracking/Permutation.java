package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    class Solution1 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> al = new ArrayList<>();
            boolean[] isValid = new boolean[nums.length];
            find(nums, al, ans, isValid);
            return ans;
        }

        public void find(int[] nums, List<Integer> al, List<List<Integer>> ans, boolean[] isValid) {
            if (nums.length == al.size()) {
                List<Integer> list = new ArrayList<>(al);
                ans.add(list);
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!isValid[i]) {
                    al.add(nums[i]);
                    isValid[i] = true;
                    find(nums, al, ans, isValid);
                    isValid[i] = false;
                    al.remove(al.size() - 1);
                }
            }
        }
    }

    class Solution2 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            find(nums, 0, ans);
            return ans;
        }

        public void find(int[] nums, int idx, List<List<Integer>> ans) {
            int n = nums.length;
            if (idx == n - 1) {
                List<Integer> al = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    al.add(nums[i]);
                }
                ans.add(al);
                return;
            }

            for (int i = idx; i < n; i++) {
                swap(nums, idx, i);
                find(nums, idx + 1, ans);
                swap(nums, idx, i);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
