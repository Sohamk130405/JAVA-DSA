package LinkedList;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class basic {

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        // System.out.println(a.val);
        // System.out.println(a.next.val);
        // System.out.println(a.next.next.val);
        // System.out.println(a.next.next.next.val);
        // System.out.println(a.next.next.next.next.val);

        print(a);
        recursivePrint(a);

    }

    private static void recursivePrint(Node head) {
        if (head == null)
            return;
        System.out.println(head.val);
        recursivePrint(head.next);

    }

    private static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
