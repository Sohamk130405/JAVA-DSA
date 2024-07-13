package Strings;

public class mostOccuringCharacter {
    public static void main(String[] args) {
        String s = "abrab";
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int ascii = (int)s.charAt(i);
            freq[ascii-97]++;
        }
        int max = 0;
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] > max){
                max=freq[i];
            }
        }
        System.out.println("Frequency = " + max);
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] == max){
                System.out.print((char)(i+97) + " ");
            }
        }

        
    }
}
