package DynamicProgramming.String;

public class Supersequence {
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
    }

    public static String shortestCommonSupersequence(String a, String b) {
        String lcs = PrintLCS.print(a, b);
        int i = 0, j = 0, k = 0;
        String scs = "";

        while (k < lcs.length() && i < a.length() && j < b.length()) {
            while (a.charAt(i) != lcs.charAt(k)) {
                scs += a.charAt(i++);
            }
            while (b.charAt(j) != lcs.charAt(k)) {
                scs += b.charAt(j++);
            }
            scs += lcs.charAt(k++);
            i++;
            j++;
        }
        while (i < a.length())
            scs += a.charAt(i++);
        while (j < b.length())
            scs += b.charAt(j++);

        return scs;
    }

}
