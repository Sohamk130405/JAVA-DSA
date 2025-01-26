public class LongestSubarray {

}

class Solution {
    public int longestSubarray(int[] arr) {
        int i = 0, j = 0, zeroes = 0, maxLength = 0;
        while (j < arr.length) {
            if (arr[j] == 0) {
                zeroes++;
            }
            while (zeroes > 1) {
                if (arr[i] == 0) {
                    zeroes--;
                }
                i++;
            }
            maxLength = Math.max(maxLength, j - i);
            j++;
        }
        return maxLength;
    }
}