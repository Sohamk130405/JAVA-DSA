package Recursion.Strings;

import java.util.ArrayList;

public class subsets {
    // T.C = O(2^n)
    static ArrayList<String> arr = new ArrayList<>();
    public static void main(String[] args) {
        String s = "abc";
        printSubsets(s, 0, "");
        sub(s, 0, "");
        System.out.println(arr);
    }

    private static void printSubsets(String s, int i, String t) {

        if (i == s.length()) {
            System.out.println(t);
            return;
        }
        printSubsets(s, i+1, t+s.charAt(i));//take
        printSubsets(s, i + 1, t);//not take
    }

    private static void sub(String s, int i, String t) {
        
        if (i == s.length()) {
            arr.add(t);
            return;
        }
        sub(s, i + 1, t + s.charAt(i));// take
        sub(s, i + 1, t);// not take
       
    }
}
