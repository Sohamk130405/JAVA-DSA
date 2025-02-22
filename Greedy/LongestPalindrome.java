package Greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {
    class Solution1 {
        public int longestPalindrome(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int cnt = 0;
            boolean isOddExist = false;
            for (int freq : map.values()) {
                if (freq % 2 == 0) {
                    cnt += freq;
                } else {
                    cnt += freq - 1;
                    isOddExist = true;
                }
            }
            return isOddExist ? cnt + 1 : cnt;
        }
    }

    class Solution2 {
        public int longestPalindrome(String s) {
            int len = s.length();
            Map<Character, Integer> map = new HashMap<>();
            int oddCount = 0;
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.get(ch) % 2 == 1)
                    oddCount++;
                else
                    oddCount--;
            }
            return oddCount > 0 ? len - oddCount + 1 : len;
        }
    }

    class Solution3 {
        public int longestPalindrome(String s) {
            int len = s.length();
            Set<Character> set = new HashSet<>();
            int count = 0;
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                if (set.contains(ch)) {
                    set.remove(ch);
                    count += 2;
                } else
                    set.add(ch);
            }
            return set.size() > 0 ? count + 1 : count;
        }
    }
}
