package DoublyLinkedList;

class Node {
    int val;
    Node next;
    Node prev;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }
}

class DLL {
    Node head;
    Node tail;
    int size;

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void insertAtEnd(int val) {
        Node temp = new Node(val);
        if (size == 0)
            head = tail = temp;
        else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
    }

    void insertAtStart(int val) {
        Node temp = new Node(val);
        if (size == 0)
            head = tail = temp;
        else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        size++;
    }

    void insert(int i, int val) {
        if (i == 0) {
            insertAtStart(val);
            return;
        }
        if (i == size) {
            insertAtEnd(val);
            return;
        }
        if (i > size || i < 0) {
            System.err.println("Invalid Index");
            return;
        }
        Node x = head;
        Node temp = new Node(val);
        for (int j = 0; j < i - 1; j++) {
            x = x.next;
        }
        Node y = x.next;

        x.next = temp;
        temp.prev = x;
        y.prev = temp;
        temp.next = y;
        size++;
    }

    void delete(int i) throws Error {
        if (size == 0) {
            throw new Error("No node is present in linked list");
        }
        if (i >= size || i < 0) {
            throw new Error("Invalid Index");
        }
        if (i == 0) {
            head = head.next;
            head.prev = null;
            size--;
            return;
        }
        if (i == size-1) {
            tail=tail.prev;
            tail.next = null;
            size--;
            return;
        }
        Node temp = head;
        for (int j = 0; j < i ; j++) {
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
    }
}