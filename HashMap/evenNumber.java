package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
// O(n+500); 
public class evenNumber {
    public int[] findEvenNumbers(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 100; i < 1000; i += 2) {
            int x = i;
            int a = x % 10;
            x /= 10;
            int b = x % 10;
            x /= 10;
            int c = x;

            if (map.containsKey(a)) {
                int aFreq = map.get(a);
                map.put(a, aFreq - 1);
                if (aFreq == 1)
                    map.remove(a);
                if (map.containsKey(b)) {
                    int bFreq = map.get(b);
                    map.put(b, bFreq - 1);
                    if (bFreq == 1)
                        map.remove(b);
                    if (map.containsKey(c)) {
                        al.add(i);
                    }
                    map.put(b, bFreq);
                }
                map.put(a, aFreq);
            }

        }
        int[] ans = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            ans[i] = al.get(i);
        }
        return ans;
    }

}