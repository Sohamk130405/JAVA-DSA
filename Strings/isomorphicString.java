package Strings;
// constraints any character but t and s of same length
public class isomorphicString {
    public static void main(String[] args) {
        String s = "race";
        String t = "mood";
        boolean iso = true;
        char[] arr = new char[128];
        char[] brr = new char[128];
        for (int i = 0; i < s.length(); i++) {
           char ch = s.charAt(i);
           char dh = t.charAt(i);
           int idx = (int)ch;
           if(arr[idx]=='\0') arr[idx] = dh;
           else if(arr[idx]!=dh) {
            iso = false;
           } 
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            char dh = s.charAt(i);
            int idx = (int) ch;
            if (brr[idx] == '\0')
                brr[idx] = dh;
            else if (brr[idx] != dh) {
                iso = false;
            }

        }
        System.out.println(iso);
    }
}
