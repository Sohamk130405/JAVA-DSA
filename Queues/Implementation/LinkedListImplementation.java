package Queues.Implementation;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class LinkedListImplementation {

    public static class Queue {
        Node head;
        Node tail;
        int size = 0;

        public void add(int val) {
            Node temp = new Node(val);
            if (size == 0)
                head = tail = temp;
            else {
                tail.next = temp;
                tail = temp;
            }
            tail.next = null;
            size++;
        }

        public int remove() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return -1;
            }
            int x = head.val;
            head = head.next;
            size--;
            return x;

        }

        public int peek() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return -1;
            }
            return head.val;
        }

        public boolean isEmpty() {
            return size == 0 ? true : false;
        }

        public void display() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.isEmpty());
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.display();
        q.remove();
        q.display();
        System.out.println(q.isEmpty());
        System.out.println(q.peek());
    }
}
