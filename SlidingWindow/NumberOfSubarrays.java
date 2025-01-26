public class NumberOfSubarrays {

}

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i = 1, j = k, sum = 0, cnt = 0, n = arr.length;
        for (int l = 0; l <= k - 1; l++) {
            sum += arr[l];
        }
        if (sum / k >= threshold)
            cnt++;
        while (j < n) {
            sum = sum - arr[i - 1] + arr[j];
            if (sum / k >= threshold)
                cnt++;
            i++;
            j++;
        }
        return cnt;
    }
}
