package Recursion.Basics;

public class printNto1 {
    public static void main(String[] args) {
        int n = 10;

        print_1to_n(n);
        print_nto_1(n);
    }

    private static void print_1to_n(int n) {
        if (n == 0) {
            return;
        } else {
            print_1to_n(n - 1);
            System.out.println(n);

        }
    }

    private static void print_nto_1(int n) {
        if (n == 0) {
            return;
        } else {
            System.out.println(n);
            print_nto_1(n - 1);

        }
    }
}
