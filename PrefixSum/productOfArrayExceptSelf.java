package PrefixSum;


public class productOfArrayExceptSelf {
    // M1. Brute Force
    // M2. Prefix and Suffix Product Arrays
    // M3. Prefix Array And Suffix Variable
}

class Method3 {
    // space optimized
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++)
            pre[i] = pre[i - 1] * nums[i - 1];
        int suf = 1;
        for (int i = n - 2; i >= 0; i--) {
            suf *= nums[i + 1];
            pre[i] *= suf;
        }
        return pre;
    }
}

class Method2 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = 1;
        suf[n - 1] = 1;
        for (int i = 1; i < n; i++)
            pre[i] = pre[i - 1] * nums[i - 1];
        for (int i = n - 2; i >= 0; i--)
            suf[i] = suf[i + 1] * nums[i + 1];
        for (int i = 0; i < n; i++)
            nums[i] = pre[i] * suf[i];
        return nums;

    }
}