package Stacks.InfixPostfixAndPrefix.Conversions;

import java.util.Stack;

public class prefixToInfix {

    public static void evaluate(Stack<String> val, char ch) {
        String v1 = val.pop();
        String v2 = val.pop();
        if (v1.length() == 1 && v2.length() == 1) {
            val.push('(' + v1 + ch + v2 + ')');
        } else
            val.push(v1 + ch + v2);

    }

    public static void main(String[] args) {
        Stack<String> val = new Stack<>();
        String s = "-9/*+5346";

        for (int i = s.length() - 1; i >= 0; i--) {
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
