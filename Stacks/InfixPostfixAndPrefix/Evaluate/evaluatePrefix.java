package Stacks.InfixPostfixAndPrefix.Evaluate;

import java.util.Stack;

public class evaluatePrefix {

    public static void evaluate(Stack<Integer> val, char ch) {
        int v1 = val.pop();
        int v2 = val.pop();

        if (ch == '-')
            val.push(v1 - v2);
        if (ch == '+')
            val.push(v1 + v2);
        if (ch == '*')
            val.push(v1 * v2);
        if (ch == '/')
            val.push(v1 / v2);
    }

    public static void main(String[] args) {
    
        Stack<Integer> val = new Stack<>();
        String s = "-9/*+5346";

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57)
                val.push(ascii - 48);
            else
                evaluate(val, ch);
        }

        System.out.println(val.peek());
    }
}
