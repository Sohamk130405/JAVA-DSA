package Recursion.Strings;

public class incresaingSequence {
    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        sequencePrint(1, k, n, "");
    }

    private static void sequencePrint(int i, int k, int n, String s) {
        if (s.length() == k) {
            System.out.println(s);
            return;
        }
        if (n == i) {
            if (s.length() == k - 1) {
                s += i;
                System.out.println(s);

            }

            return;
        }
        sequencePrint(i + 1, k, n, s); // not take
        s += i;
        sequencePrint(i + 1, k, n, s); // take

    }
}
