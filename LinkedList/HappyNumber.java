package LinkedList;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 6;
        String s = "";
        s += n;

        System.out.println(find(s));
    }

    private static boolean find(String s) {
        int sum = sqr(s);
        if (sum == 1)
            return true;
        s = "";
        s += sum;
        if (s.length() == 1)
            return false;
        return find(s);
    }

    private static int sqr(String s) {
        if (s.length() == 1) {
            return (int) (s.charAt(0) - '0') * ((int) s.charAt(0) - '0');
        } else {
            return ((int) (s.charAt(0) - '0') * (s.charAt(0) - '0')) + sqr(s.substring(1));
        }

    }
}
