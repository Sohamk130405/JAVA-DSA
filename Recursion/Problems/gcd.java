package Recursion.Problems;

public class gcd {
    public static void main(String[] args) {
        int a = 41;
        int b = 90;
        int gcd = hcf(a, b);
        System.out.println(gcd);
    }

    @SuppressWarnings("unused")
    private static int hcf(int a, int b, int i) {
        if (a % i == 0 && b % i == 0) {
            return i;
        } else {
            hcf(a, b, i - 1);
        }
        return 1;
    }
    
    private static int hcf(int a, int b) {
        int r = b % a;
        if (r == 0) return a;
        return hcf(r, a);
    }
}
