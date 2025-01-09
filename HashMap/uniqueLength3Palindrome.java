package HashMap;

import java.util.HashMap;
import java.util.HashSet;


public class uniqueLength3Palindrome {
    public static void main(String[] args) {
        String s = "bbcbaba";
        System.out.println(countPalindromicSubsequence(s));
    }

    public static int countPalindromicSubsequence(String s) {
        HashMap<Character, Integer> fmap = new HashMap<>();
        HashMap<Character, Integer> lmap = new HashMap<>();
       
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!fmap.containsKey(ch))
                fmap.put(ch, i);
            lmap.put(ch, i);    
           
        }
        int cnt = 0;
        for (Character ch : fmap.keySet()) {
            int fo = fmap.get(ch);
            int lo = lmap.get(ch);
            HashSet<Character> set = new HashSet<>();
            for (int i = fo+1; i < lo; i++) {
                set.add(s.charAt(i));
            }
            cnt+=set.size();
        }
       

        return cnt;

    }
}
