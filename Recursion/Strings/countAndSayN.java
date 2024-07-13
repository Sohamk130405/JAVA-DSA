package Recursion.Strings;

public class countAndSayN {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(modify(n));
    }

    public static String modify(int n) {
        if (n == 1) {
            return "1";
        }
        String s = modify(n - 1) + "@";
        String ans = "";

        int i = 0, j = 0;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j))
                j++;
            else {
                int len = j - i;
                ans += len;
                ans += s.charAt(i);
                i = j++;
            }
        }

        return ans;

    }
}
