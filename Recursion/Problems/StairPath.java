package Recursion.Problems;

public class StairPath {
    public static void main(String[] args) {
        int n = 5;

        System.out.println(ways(n));
    }

    private static int ways(int n) {
        if(n<=2) return n;
        return ways(n-1) + ways(n-2);
    }
}
