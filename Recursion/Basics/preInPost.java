package Recursion.Basics;

public class preInPost {
    public static void main(String[] args) {
        pip(3);
    }

    private static void pip(int n) {
        if(n==0) return;
        System.out.println(n); // pre
        pip(n-1);
        System.out.println(n); // In
        pip(n - 1);
        System.out.println(n); // post
    }
}
