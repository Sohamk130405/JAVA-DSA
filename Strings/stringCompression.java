package Strings;

public class stringCompression {
    public static void main(String[] args) {
        char[] chars = { 'a','a', 'b' , 'b','c','c','c'};
        StringBuilder sb = new StringBuilder("");
    
        int i = 0, j = 1;
        while (j < chars.length) {
            if (chars[i] != chars[j]) {
                int freq = j-i;
                sb.append(chars[i]);
                if (freq > 1)
                    sb.append(freq);
                i = j;
            }
            j++;
        }

        sb.append(chars[i]);
        if (j - i > 1)
            sb.append(j - i);
        
        System.out.println(sb);
        
    }
}
