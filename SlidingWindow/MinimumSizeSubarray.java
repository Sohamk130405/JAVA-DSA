public class MinimumSizeSubarray {
    public static void main(String[] args) {
        System.out.println("MinimumSizeSubarray");
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int i = 0, j = 0, sum = 0, minLength = Integer.MAX_VALUE;
        while (j < n) {
            sum += arr[j];
            while (sum >= target) {
                sum -= arr[i];
                minLength = Math.min(minLength, j - i + 1);
                i++;
            }
            j++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        if (k <= 1)
            return 0;
        int cnt = 0, product = 1, i = 0, j = 0, n = arr.length;
        while (j < n) {
            product *= arr[j];
            while (product >= k) {
                product /= arr[i++];
            }
            cnt += j - i + 1;
            j++;
        }
        return cnt;
    }
}