import java.util.HashMap;
import java.util.HashSet;

// T.C = O(n*avgLen) = S.C
public class basic {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(20);
        set.add(1000);
        set.add(10);
        set.add(-8);
        set.add(20);
        System.out.println(set);

        String s = "cat";
        String t = "rat";
        if (s.length() != t.length())
            ;
        int len = s.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            char chr = t.charAt(i);
            if (map1.containsKey(ch)) {
                int val = map1.get(ch);
                map1.put(ch, val + 1);
            }
            if (map2.containsKey(chr)) {
                int val = map2.get(chr);
                map2.put(chr, val + 1);
            }
            if (!map1.containsKey(ch)) {
                map1.put(ch, 1);
            }
            if (!map2.containsKey(chr)) {
                map2.put(chr, 1);
            }
        }
        System.out.println(map1);
        System.out.println(map2);

        

    }
}