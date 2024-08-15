package Stacks.InfixPostfixAndPrefix.Evaluate;

import java.util.Stack;

public class prefix {

    public static void evaluate(Stack<String> val, Stack<Character> op) {
        String v2 = val.pop();
        String v1 = val.pop();
        char ch = op.peek();
        val.push(ch + v1 + v2);
        op.pop();
    }

    public static void main(String[] args) {
        String s = "9-(5+3)*4/6";

        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57)
                val.push(ch + "");
            else if (op.isEmpty() || ch == '(' || op.peek() == '(')
                op.push(ch);

            else if (ch == ')') {
                while (op.peek() != '(') {
                    evaluate(val, op);
                }
                op.pop();
            } else {

                if (ch == '+' || ch == '-') {
                    evaluate(val, op);
                    op.push(ch);
                }

                if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        evaluate(val, op);
                        op.push(ch);
                    } else
                        op.push(ch);
                }
            }
        }

        while (val.size() > 1) {
            evaluate(val, op);
        }

        System.out.println(val.peek());
    }
}
