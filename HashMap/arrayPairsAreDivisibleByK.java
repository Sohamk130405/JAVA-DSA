package HashMap;

import java.util.HashMap;

public class arrayPairsAreDivisibleByK {
    public static void main(String[] args) {
        int[] arr = { -1, 1, 2, -2, 3, -3, 4, -4 };
        int k = 3;
        System.out.println(canArrange(arr, k));
    }

    public static boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            ele = ((ele% k)+k)%k;
            if (ele < 0)
                ele += k;
            map.put(ele % k, map.getOrDefault(ele % k, 0) + 1);
        }
        System.out.println(map);
        if (map.containsKey(0)) {
            if(map.get(0)%2!=0) return false;
            map.remove(0);
        }
        for (int key : map.keySet()) {
            int rem = k -key;
            if(!map.containsKey(rem)) return false;
            int keyFreq = map.get(key);
            int remFreq = map.get(rem);
            if(keyFreq!=remFreq) return false;
        }

        

        return true;

    }
}
