package Strings;

import java.util.Scanner;

public class printAllSubstrings {
    @SuppressWarnings("resource")
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <= str.length() ; j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }
}
