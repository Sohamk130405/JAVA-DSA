package Strings;

public class intToString {
    public static void main(String[] args) {
        int x = 1024;
        // String s = x+"";
        String s = Integer.toString(x);

        System.out.println(s);
        System.out.println(s.length());
    }
}