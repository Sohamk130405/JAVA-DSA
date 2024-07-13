package Strings;

import java.util.Scanner;

public class basics {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "soham";
        System.out.print("Enter Your Name: ");
        String inpStr = sc.nextLine();
        System.out.println("Hi " + inpStr);
        System.out.println(str.charAt(3)); // h
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
