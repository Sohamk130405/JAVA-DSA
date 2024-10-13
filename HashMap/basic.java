package HashMap;

import java.util.HashMap;

public class basic {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 2);
        map.put('a', 0);
        map.put('c', 2);
        System.out.println(map);
    }
}
