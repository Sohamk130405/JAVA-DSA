package Recursion.Strings;

import java.util.ArrayList;

public class permutations {
    // T.C = O(n!)
    static ArrayList<String> arr = new ArrayList<>();

    private static void printPermutaions(String ans, String s) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            printPermutaions(ans + ch, left + right);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        printPermutaions("", s);

        System.out.println(arr);
    }

}
