package Strings;

import java.util.Arrays;

public class isValidAnagram {
    public static void main(String[] args) {
        String s = "Hello I am World";
        String t = "rldo HellWo I ma";
        boolean isValidAnagram = false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        for (int i = 0; i < arr1.length && arr1.length == arr2.length; i++) {
            if (arr1[i] != arr2[i]) {
                isValidAnagram = false;
                break;
            } else {
                isValidAnagram = true;
            }
        }

        if(isValidAnagram){
            System.out.println("Anagram");
        }else{
            System.out.println("Not a Anagram");
        }

    }
}
