package Queues.Problems;

import java.util.Stack;

class MyQueue { //pushg efficient
    Stack<Integer> st = new Stack<>();
    Stack<Integer> qt = new Stack<>();
    int size = 0;

    public MyQueue() {

    }

    public void push(int x) {
        st.push(x);
        size++;
    }

    public int pop() {
        while (st.size() > 1) {
            qt.push(st.pop());
        }
        int x = st.pop();
        while (qt.size() > 0) {
            st.push(qt.pop());
        }
        size--;
        return x;
    }

    public int peek() {
        while (st.size() > 1) {
            qt.push(st.pop());
        }
        int x = st.peek();
        while (qt.size() > 0) {
            st.push(qt.pop());
        }
        return x;
    }

    public boolean empty() {
        if (size == 0)
            return true;
        else
            return false;
    }
}

class MyQueue2 { // pop efficient
    Stack<Integer> st = new Stack<>();
    Stack<Integer> qt = new Stack<>();
    int size = 0;

    public MyQueue2() {

    }

    public void push(int x) {
        if (size == 0)
            st.push(x);
        else {
            while (st.size() > 0) {
                qt.push(st.pop());
            }
            st.push(x);
            while (qt.size() > 0) {
                st.push(qt.pop());
            }
        }
        size++;
    }

    public int pop() {
        size--;
        return st.pop();
    }

    public int peek() {
        return st.peek();
    }

    public boolean empty() {
        if (size == 0)
            return true;
        else
            return false;
    }
}