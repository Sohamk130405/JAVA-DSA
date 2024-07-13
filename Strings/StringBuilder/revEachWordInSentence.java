package Strings.StringBuilder;

public class revEachWordInSentence {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("I am soham kolhatkar");
        int i = 0, j = 0;
        while (j != sb.length()) {
            if (sb.charAt(j) == ' ') {
                reverse(sb, i, j - 1);
                i = j + 1;
            } else if (j == sb.length() - 1) {
                reverse(sb, i, j);
            }
            j++;
        }

        System.out.println(sb);

    }

    private static void reverse(StringBuilder sb, int i, int j) {

        while (i <= j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }

    }
}
