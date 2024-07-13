package Strings;

public class maxNumString {
    public static void main(String[] args) {
        String[] str = { "00255", "3274", "032364", "00324","00000007732874" };
        String maxS = str[0];
        for (int i = 1; i < str.length; i++) {
            maxS = maxOfTwoString(maxS, str[i]);
        }
        System.out.println(maxS);
    }

    private static String maxOfTwoString(String s, String t) {
        String s1 = truncateZero(s);
        String t1 = truncateZero(t);
        if (s1.length() > t1.length())
            return s;
        if (s1.length() < t1.length())
            return t;

        for (int i = 0; i < s1.length(); i++) {
           if(s1.charAt(i) != t1.charAt(i)){
            if(s1.charAt(i) > t1.charAt(i)) return s;
            else 
                return t;
                  
           }
        }
        return s;
    }

    private static String truncateZero(String t) {
        
        for (int j = 0; j < t.length(); j++) {
            if(t.charAt(j)!='0') return t.substring(j);
        }
        return t;
    }
}
