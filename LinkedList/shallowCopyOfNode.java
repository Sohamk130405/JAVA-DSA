package LinkedList;

public class shallowCopyOfNode {
    public static void main(String[] args) {
        Node a = new Node(100); // new node
        Node temp = a;  // temp points to a  (shallow copy)
        System.out.println(a);
        System.out.println(temp); 
        System.out.println(a.val);
        temp.val = 12;
        System.out.println(a.val);
    }
}
