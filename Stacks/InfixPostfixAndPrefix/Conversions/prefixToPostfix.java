package Stacks.InfixPostfixAndPrefix.Conversions;

import java.util.Stack;

public class prefixToPostfix {

    public static void evaluate(Stack<String> val, char ch) {
        String v1 = val.pop();
        String v2 = val.pop();
        val.push(v1 + v2 + ch);

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
