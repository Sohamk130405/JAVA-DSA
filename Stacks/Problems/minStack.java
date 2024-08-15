package Stacks.Problems;

import java.util.Stack;

// method 1: S.C = O(n)
class MinStackON {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStackON() {

    }

    public void push(int val) {
        if (st.size() == 0) {
            st.push(val);
            min.push(val);
        } else {
            st.push(val);
            min.push(Math.min(min.peek(), val));
        }
    }

    public void pop() {
        st.pop();
        min.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

// method 2: S.C = O(1)

class MinStackO1 {
    Stack<Long> st = new Stack<>();
    long min;

    public MinStackO1() {

    }

    public void push(int val) {
        long x = (long) val;
        if (st.size() == 0) {
            st.push(x);
            min = x;
        } else if (x >= min)
            st.push(x);
        else if (x < min) {
            st.push(2 * x - min);
            min = x;
        }
    }

    public void pop() {
        if (st.size() == 0)
            return;
        else if (st.peek() >= min)
            st.pop();
        else if (st.peek() < min) {
            min = (2 * min - st.peek());
            st.pop();
        }
    }

    public int top() {
        if (st.size() == 0)
            return -1;
        long peek = st.peek();
        if (peek >= min)
            return (int) peek;
        if (peek < min)
            return (int) min;
        return 0;
    }

    public int getMin() {
        if (st.size() == 0)
            return -1;
        return (int) min;
    }
}
