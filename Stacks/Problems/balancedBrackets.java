package Stacks.Problems;

import java.util.Stack;

public class balancedBrackets {
    public static void main(String[] args) {

        String s = "([{}])";
        String t = "(()())";

        System.out.println(isValid(s));
        System.out.println(isBalanced(t));

    }

    public static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                st.push(ch);
            else {
                if (st.size() == 0)
                    return false;
                else
                    st.pop();
            }
        }

        if (st.size() == 0)
            return true;
        else
            return false;
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else {
                if (st.size() == 0)
                    return false;
                else if (st.peek() == '[' && ch == ']')
                    st.pop();
                else if (st.peek() == '(' && ch == ')')
                    st.pop();
                else if (st.peek() == '{' && ch == '}')
                    st.pop();
                else
                    return false;
            }
            System.out.println(st);
        }

        if (st.size() == 0)
            return true;
        else
            return false;
    }
}