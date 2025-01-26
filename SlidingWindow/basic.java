public class basic {
    public static void main(String[] args) {
        int[] arr = { 10, 20 };
        System.out.println(maximumSumSubarraySizeK(arr, 2));
    }

    // public static int maximumSumSubarraySizeK(int[] arr, int k) {
    // // Brute Force technique
    // int n = arr.length;
    // int maxSum = 0;
    // for (int i = 0; i < n - k + 1; i++) {
    // int sum = 0;
    // for (int j = i; j < i + k; j++) {
    // sum += arr[j];
    // }
    // maxSum = Math.max(maxSum, sum);
    // }
    // return maxSum;
    // }

    public static int maximumSumSubarraySizeK(int[] arr, int k) {
        // Sliding Window Technique
        int n = arr.length;
        int maxSum = 0;
        int i = 1, j = k, sum = 0;
        for (int l = 0; l <= k - 1; l++) { 
            sum += arr[l];
        }
        maxSum = sum;
        while (j < n) {
            sum = sum - arr[i - 1] + arr[j];
            maxSum = Math.max(maxSum, sum);
            i++;
            j++;
        }
        return maxSum;
    }

}
