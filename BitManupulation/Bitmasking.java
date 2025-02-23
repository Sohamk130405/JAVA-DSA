package BitManupulation;

public class Bitmasking {
    public static void main(String[] args) {
        System.out.println(isSet(3, 60));
        System.out.println(setBit(2, 5));
        System.out.println(clearBit(2, 5));
        System.out.println(toggleBit(2, 5));
    }

    // check if the kth bit is set
    public static boolean isSet(int k, int n) {
        int mask = 1 << k;
        return (n & mask) != 0;
    }

    // turn on the kth bit
    public static int setBit(int k, int n) {
        int mask = 1 << k;
        return n | mask;
    }

    // turn of the kth bit
    public static int clearBit(int k, int n) {
        int mask = 1 << k;
        return n & ~mask;
    }

    // toggle the kth bit
    public static int toggleBit(int k, int n) {
        int mask = 1 << k;
        return n ^ mask;
    }

}
