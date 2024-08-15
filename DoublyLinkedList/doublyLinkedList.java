package DoublyLinkedList;

public class doublyLinkedList {


    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void printReverse(Node tail) {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
   
    public static void display(Node x) {
        Node temp = x;
        while (temp.prev != null) {;
            temp = temp.prev;
        }
        print(temp);
        System.out.println();
    }
   
    public static void main(String[] args) {


        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        a.next = b ; b.prev = a;
        b.next = c; c.prev = b;
        c.next = d; d.prev = c;

        print(a);
        printReverse(d);
        display(c);


        DLL list = new DLL();
        list.insertAtEnd(0);
        list.insertAtEnd(1);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.display();
        list.insertAtStart(5);
        list.display();
        list.insert(5, 7);
        list.display();
        list.delete(5);
        list.display();


        }
}
