package HashMap;

import java.util.HashMap;
import java.util.HashSet;

public class uniqueFreq {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (Integer freq : map.values()) {
            if (set.contains(freq)) {
                return false;
            } else {
                set.add(freq);
            }
        }
        return true;

    }
}
