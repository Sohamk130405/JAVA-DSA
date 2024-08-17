package LinkedList;

class LinkedList {
    Node head;
    Node tail;
    int size;

    void insertAtEnd(int val) { // T.C = O(1) S.C = O(1)
        Node temp = new Node(val);
        if (head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    void insertAtStart(int val) { // T.C = O(1) S.C = O(1)
        Node temp = new Node(val);
        if (head == null) {
            head = tail = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        size++;
    }

    void insert(int i, int val) { // T.C = O(n) S.C = O(1)
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
        temp.next = x.next;
        x.next = temp;
        size++;
    }

    int get(int i) throws Error { // T.C = O(n) S.C = O(1)
        if (i >= size || i < 0) {
            throw new Error("Invalid Index");
        }
        if (i == size - 1)
            return tail.val;
        Node temp = head;
        for (int j = 0; j < i; j++) {
            temp = temp.next;
        }

        return temp.val;

    }

    void set(int i, int x) throws Error { // T.C = O(n) S.C = O(1)
        if (i >= size || i < 0) {
            throw new Error("Invalid Index");
        }
        if (i == size - 1) {
            tail.val = x;
            return;
        }

        Node temp = head;
        for (int j = 0; j < i; j++) {
            temp = temp.next;
        }
        temp.val = x;

    }

    void display() { // T.C = O(n) S.C = O(1)
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    int size() { // T.C = O(1) S.C = O(1)
        return size;
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
            size--;
            return;
        }
        Node temp = head;
        for (int j = 0; j < i - 1; j++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        if (i == size - 1)
            tail = temp;
        size--;
    }

    // questions
    void middleOfLinkedList() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }
        head = slow;
        display();
    }

    void swapNodes(int k) {
        if (head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        while (k - 1 > 0) {
            fast = fast.next;
            k--;
        }

        Node temp = fast;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        int x = slow.val;
        slow.val = temp.val;
        temp.val = x;

        display();

    }

    void removeDupicates() {
        Node i = head;
        Node j = head.next;

        while (j != null) {
            if (i.val == j.val) {
                j = j.next;
            } else if (i.val != j.val) {
                i.next = j;
                i = j;
                j = j.next;
            }
        }
        i.next = null;
        tail = i;
    }

    void rotateList(int k) {

        if (head == null || head.next == null)
            return;
        Node temp = head;
        int n = 0;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        k %= n;
        if (k == 0)
            return;
        Node slow = head;
        Node fast = head;

        for (int i = 1; i <= k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        Node newHead = slow.next;
        slow.next = null;
        fast.next = head;
        head = newHead;
    }

    void partition(int x) {
        if (head == null || head.next == null)
            return;
        Node a = new Node(0);
        Node b = new Node(0);

        Node tempA = a;
        Node tempB = b;
        Node temp = head;
        while (temp != null) {
            if (temp.val < x) {
                tempA.next = temp;
                tempA = temp;
            } else {
                tempB.next = temp;
                tempB = temp;
            }
            temp = temp.next;
        }
        a = a.next;
        b = b.next;
        tempA.next = b;
        tempB.next = null;
        if (a == null) {
            head = b;
            return;
        }
        head = a;
    }

    Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node temp = dummy;
        Node tempA = a;
        Node tempB = b;

        while (tempA != null && tempB != null) {
            if (tempA.val <= tempB.val) {
                temp.next = tempA;
                tempA = tempA.next;
            } else {
                temp.next = tempB;
                tempB = tempB.next;
            }
            temp = temp.next;
        }
        if (tempA == null)
            temp.next = tempB;
        else
            temp.next = tempA;
        return dummy.next;
    }

    Node mergeKLists(Node[] lists) {
        int n = lists.length;
        if (n == 0)
            return null;
        if (n == 1)
            return lists[0];
        if (n == 2)
            return merge(lists[0], lists[1]);

        Node[] firstHalf = new Node[n / 2];
        Node[] secondHalf = new Node[n - n / 2];
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            firstHalf[i] = lists[i];
        }
        for (int i = mid; i < n; i++) {
            secondHalf[i - mid] = lists[i];
        }

        Node a = mergeKLists(firstHalf);
        Node b = mergeKLists(secondHalf);
        return merge(a, b);

    }

    Node sort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node firstHalf = head;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = slow.next;
        slow.next = null;
        firstHalf = sort(firstHalf);
        secondHalf = sort(secondHalf);
        return merge(firstHalf, secondHalf);
    }

    void reverse() {
        if (head == null || head.next == null)
            return;
        Node prev = null;
        Node curr = head;
        Node temp = head;

        while (temp != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
    }

    void reorderList() {
        if (head == null || head.next == null)
            return;
        Node a = new Node(-1);
        Node b = new Node(-1);
        Node t1 = a;
        Node t2 = b;
        Node temp = head;
        Node curr = head;
        int n = 0;

        while (temp != null) {
            if (n % 2 == 0) {
                t1.next = curr;
                t1 = t1.next;
            } else {
                t2.next = curr;
                t2 = t2.next;
            }
            temp = temp.next;
            curr.next = null;
            curr = temp;
            n++;
        }

        a = a.next;
        b = b.next;
        t1.next = b;
    }
}

public class implementationLL {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        // ArrayList<Integer> arr = new ArrayList<>();

        // list.insertAtStart(6);
        // list.insert(1, 8);
        // list.display();
        // System.out.println(list.size());
        // System.out.println(list.get(3));
        // list.set(2, 33);
        // list.display();
        // list.delete(4);
        // list.display();
        // System.out.println(list.tail.val);
        // System.out.println(list.size());

        list.display();
        // Node temp = list.head;
        // Node temp2 = list.head;
        list.reorderList();
        list.display();
        // list.middleOfLinkedList();

    }
}
