package HashMap;

import java.util.HashMap;

class validAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int len = s.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char key = s.charAt(i);
            map1.put(key, map1.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            char key = t.charAt(i);
            map2.put(key, map2.getOrDefault(key, 0) + 1);
        }

        for (Character key : map1.keySet()) {
            int freq1 = map1.get(key);
            if (!map2.containsKey(key))
                return false;
            int freq2 = map2.get(key);
            if (freq1 != freq2)
                return false;
        }

        return true;
    }
}
