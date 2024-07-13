package Strings.StringBuilder;

import java.util.Arrays;

public class stringSort {
    public static void main(String[] args) {

        // String Sorting
        String str = "soham";
        // Strings are immutable so convert it into charArray
        char[] ch = str.toCharArray();

        for(char ele : ch){
            System.out.print(ele);
        }
        System.out.println();
        Arrays.sort(ch);
        for (char ele : ch) {
            System.out.print(ele);
        }
        System.out.println();


        // StringBuilder sorting 
        // Similar process
        StringBuilder sb = new StringBuilder("kolhatkar");
        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        for (char ele : arr) {
            System.out.print(ele);
        }
        System.out.println();
    }
}
