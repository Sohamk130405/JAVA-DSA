package Queues.Problems;

import java.util.*;

class MyStack {  // push efficient
    Queue<Integer> q = new LinkedList<>();
    int size = 0;

    public MyStack() {

    }

    public void push(int x) {
        q.add(x);
        size++;
    }

    public int pop() {
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
        size--;
        return q.remove();
    }

    public int top() {
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
        int x = q.peek();
        q.add(q.remove());
        return x;
    }

    public boolean empty() {
        if (size == 0)
            return true;
        else
            return false;
    }
}


class MyStack2 { // pop efficient
    Queue<Integer> q = new LinkedList<>();
    int size = 0;

    public MyStack2() {

    }

    public void push(int x) {
        q.add(x);
        for (int i = 0; i < size; i++) {
            q.add(q.remove());
        }
        size++;
    }

    public int pop() {
        size--;
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        if (size == 0)
            return true;
        else
            return false;
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
