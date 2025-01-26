public class LongestOnes {

}

class Solution {
    public int longestOnes(int[] arr, int k) {
        int i = 0, j = 0, maxLen = 0, n = arr.length, zeroes = 0;

        while (j < n) {
            if (arr[j] == 0)
                zeroes++;

            while (zeroes > k) {
                if (arr[i] == 0)
                    zeroes--;
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;

    }
}
