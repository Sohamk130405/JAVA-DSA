package Stacks.LinkedListImplementation;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class Stack {

    private Node head = null;
    private int size = 0;

    void push(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        size++;
    }

    int pop() {
        if (head == null) {
            System.err.println("Stack is empty");
            return -1;
        }
        int x = head.val;
        head = head.next;
        size--;
        return x;
    }

    int peek() {
        if (head == null) {
            System.err.println("Stack is empty");
            return -1;
        }
        return head.val;
    }

    void displayRecursive(Node head) {
        if (head == null)
            return;
        displayRecursive(head.next);
        System.out.print(head.val + " ");
    }

    void display() {
        displayRecursive(head);
        System.out.println();
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
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
        st.push(5);
        st.display();
        st.push(6);
        st.display();

    }
}
