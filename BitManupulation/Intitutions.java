package BitManupulation;

public class Intitutions {
    // clear the rightmost set bit
    public static int rightmostSetBit(int n) {
        // method 1
        // int k = 0;
        // int m = n;
        // while (m % 2 == 0) {
        // k++;
        // m = m >> 1;
        // }
        // int mask = 1 << k;
        // return n & ~mask;

        // method 2
        return n & (n - 1);
    }

    // check if the number is power of 2
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n & n - 1) == 0;
    }

    // check if the number is power of 4
    public static boolean isPowerOfFour(int n) {
        // method 1
        // if (n <= 0)
        // return false;
        // double sqrt = Math.sqrt(n);
        // if (sqrt * sqrt != n)
        // return false;
        // return (n & n - 1) == 0;

        // method 2
        if (n <= 0)
            return false;
        return (n & n - 1) == 0 && (n % 3 == 1);
    }

    public static int numberOf1Bits(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= (n - 1);
            cnt++;
        }
        return cnt;
    }

    public static int minBitFlips(int start, int goal) {
        int n = start ^ goal;
        int cnt = 0;
        while (n != 0) {
            n &= (n - 1);
            cnt++;
        }
        return cnt;
    }

    public static int reverseBits(int n) {
        int i = 0, j = 31;
        while (i < j) {
            int iMask = 1 << i;
            int jMask = 1 << j;
            boolean iOn = (n & iMask) != 0;
            boolean jOn = (n & jMask) != 0;
            if (iOn != jOn) {
                n ^= iMask;
                n ^= jMask;
            }
        }
        return n;
    }

    public static int xorTill(int n) {
        if (n % 4 == 0)
            return n;
        if (n % 4 == 1)
            return 1;
        if (n % 4 == 2)
            return n + 1;
        return 0;
    }

    public static int xorInRange(int a, int b) {
        return xorTill(b) ^ xorTill(a - 1);
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            arr[i] = (arr[i] ^ arr[i - 1]);
        }

        int m = queries.length;
        int[] ans = new int[m];
        
        for (int i = 0; i < m; i++) {
            int left = queries[i][0] == 0 ? 0 : arr[queries[i][0] - 1];
            int right = arr[queries[i][1]];
            ans[i] = right ^ left;
        }

        return ans;
    }
}
