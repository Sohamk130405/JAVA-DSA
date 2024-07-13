package Recursion.Strings;

public class binaryStringsWithoutConsecutive1s {
    public static void main(String[] args) {
        int n = 4;
        genStr("", n);
    }
    private static void genStr(String ans, int n) {
        int m =ans.length();
        if (m == n) {
            System.out.println(ans);
            return;
        }
        if (m > 0 && ans.charAt(m - 1) == '1') {
            genStr(ans + 0, n);
            return;
        }
        genStr(ans + 1, n);
        genStr(ans + 0, n);
    }
}
