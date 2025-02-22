package Greedy;

import java.util.Arrays;

public class MaxSumKNegotiation {
    public static void main(String[] args) {
        int arr[] = { 2, -3, -1, 5, -4 };
        System.out.println(largestSumAfterKNegations(arr, 5));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        while (k > 0 && i < n && nums[i] < 0) {
            nums[i++] *= -1;
            k--;
        }
        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] *= -1;
        }
        int sum = 0;
        for (int ele : nums) {
            sum += ele;
        }
        return sum;
    }
}
