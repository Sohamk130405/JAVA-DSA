package Stacks.InfixPostfixAndPrefix.Conversions;

import java.util.Stack;

public class postfixToInfix {
    public static void evaluate(Stack<String> val, char ch) {
        String v2 = val.pop();
        String v1 = val.pop();
        if (v1.length() == 1 && v2.length() == 1) {
            val.push('(' + v1 + ch + v2 + ')');
        } else
            val.push(v1 + ch + v2);
    }

    public static void main(String[] args) {
        Stack<String> val = new Stack<>();
        String s = "953+4*6/-";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57)
                val.push(ch + "");
            else
                evaluate(val, ch);
        }

        System.out.println(val.peek());
    }
}
