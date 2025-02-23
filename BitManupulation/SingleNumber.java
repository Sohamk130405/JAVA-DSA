package BitManupulation;

public class SingleNumber {
    class Solution {
        public int singleNumber1(int[] nums) {
            int ans = nums[0];
            for (int i = 1; i < nums.length; i++) {
                ans ^= nums[i];
            }
            return ans;
        }

        public int[] singleNumber2(int[] nums) {
            // method 1 Using HashMap
            // method 2 sorting
            // method 3 Bit Manipulation
            int xor = 0;
            for (int ele : nums) {
                xor ^= ele;
            }
            int rightBitOff = xor & xor - 1;
            int mask = rightBitOff ^ xor;
            int b1 = 0, b2 = 0;
            for (int ele : nums) {
                if ((ele & mask) == 0) {
                    b1 ^= ele;
                } else {
                    b2 ^= ele;
                }
            }
            return new int[] { b1, b2 };
        }
    }
}
