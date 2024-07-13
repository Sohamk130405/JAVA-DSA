package Recursion.Strings;

public class skipCharacter {
    public static void main(String[] args) {
        String s = "fbsmgha aakhrvhjaa";
        skip(s, s.length() - 1);
    }

    private static void skip(String s, int n) {
        if (n==-1) return;
        skip(s, n - 1);
        if (s.charAt(n) != 'a') {
            System.out.print(s.charAt(n));
        }
    }
}
