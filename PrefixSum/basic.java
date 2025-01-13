package PrefixSum;

public class basic {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 5, 8 };
        runningSum(arr);
    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        return nums;
    }

}

// Range Sum Query - Immutable 
class NumArray {
    int[] pre;

    public NumArray(int[] nums) {
        pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left > 0)
            return pre[right] - pre[left - 1];
        return pre[right];
    }
}

// Find Pivot Index
class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                leftSum = sumRange(nums, 0, i - 1);
            rightSum = sumRange(nums, i + 1, n - 1);
            if (leftSum == rightSum)
                return i;

        }

        return -1;
    }

    public int sumRange(int[] nums, int left, int right) {
        if (left > 0)
            return nums[right] - nums[left - 1];
        return nums[right];
    }
}

// Find Prefix score of an array

class PrefixScore {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            ans[i] = (long) (nums[i] + max);
        }

        for (int i = 1; i < n; i++)
            ans[i] += ans[i - 1];
        return ans;
    }
}


