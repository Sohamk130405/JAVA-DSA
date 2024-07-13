package Strings.StringBuilder;

import java.util.Scanner;

public class basics {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // basics
        StringBuilder sb = new StringBuilder("Hello");
        sb.setCharAt(2, 'x');
        System.out.println(sb);

        // toogle the charaters of string
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 65 && ascii <= 90) { // capital
                ascii += 32;
            } else if (ascii >= 97 && ascii <= 122) { // small
                ascii -= 32;
            }
            ch = (char) ascii;
            str.setCharAt(i, ch);
        }
        System.out.println(str);
    }
}
