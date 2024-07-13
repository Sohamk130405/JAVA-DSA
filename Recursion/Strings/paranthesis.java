package Recursion.Strings;

import java.util.ArrayList;

public class paranthesis {
    static ArrayList<String> arr = new ArrayList<>();

    public static void main(String[] args) {
        int n = 3;

        generateParanthesis(n, "", 0, 0);
        System.out.println(arr);
    }

    private static void generateParanthesis(int n, String s, int opn, int clo) {
        if (s.length() == 2 * n) {
            arr.add(s);
            return;
        }
        if (opn < n) {
            generateParanthesis(n, s + "(", opn + 1, clo);

        }
        if (clo < opn) {
            generateParanthesis(n, s + ")", opn, clo + 1);
        }

    }
}
