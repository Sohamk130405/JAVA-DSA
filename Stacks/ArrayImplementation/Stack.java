package Stacks.ArrayImplementation;

public class Stack {

    private int arr[] = new int[4];
    private int idx = 0;

    void push(int val) {
        if (isFull()) {
            System.err.println("Stack is full");
            return;
        }
        arr[idx++] = val;
    }

    int peek() {
        if (idx == 0) {
            System.err.println("Stack is empty!");
            return -1;
        }
        return arr[idx - 1];
    }

    int pop() {
        if (idx == 0) {
            System.err.println("Stack is empty!");
            return -1;
        }
        int x = arr[idx - 1];
        arr[idx - 1] = 0;
        idx--;
        return x;
    }

    int size() {
        return idx;
    }

    int capacity() {
        return arr.length;
    }

    boolean isEmpty() {
        if (idx == 0)
            return true;
        return false;
    }

    boolean isFull() {
        if (idx == arr.length)
            return true;
        return false;
    }

    void display() {
        for (int i = 0; i < idx; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        System.out.println(st.isEmpty());
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.display();
        System.out.println(st.isEmpty());

        System.out.println(st.pop());
        System.out.println(st.size());
        st.display();
        st.push(4);
        st.display();
        System.out.println(st.isFull());
        st.push(6);
    }

}
