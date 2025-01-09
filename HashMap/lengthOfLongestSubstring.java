package HashMap;

import java.util.HashMap;

public class lengthOfLongestSubstring {

    public int len(String s) {
        int n = s.length();
        if (n == 0 || n == 1)
            return n;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < n) {
            char ch = s.charAt(j);
            if (map.containsKey(ch) && map.get(ch) >= i) {
                int len = j - i;
                max = Math.max(max, len);
                i = map.get(ch) + 1;
            }
            map.put(ch, j);
            j++;
        }
        int len = j - i;
        max = Math.max(max, len);
        return max;
    }
}