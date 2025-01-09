package HashMap;

import java.util.HashMap;

public class nicePairs {
    public static void main(String[] args) {
        int[] arr = { 11, 1, 42, 97 };
        System.out.println(countNicePairs(arr));
    }

    public static int countNicePairs(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            int rev = reverse(n);
            if (map.containsKey(n - rev)) {
                cnt += map.get(n - rev);
                cnt %= 1000000007;
            } 
            map.put(n - rev, map.getOrDefault(n - rev, 0) + 1);
        }

        return cnt;
    }

    public static int reverse(int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum * 10 + n % 10;
            n /= 10;
        }
        return sum;
    }

}
