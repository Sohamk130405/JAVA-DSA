package Recursion.Basics;

public class factorial {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(fact(n));
    }

    private static int fact(int n) {
        if(n<=1) return 1;
        return fact(n-1) * n;
    }
}
