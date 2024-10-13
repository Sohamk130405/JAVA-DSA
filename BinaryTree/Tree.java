package BinaryTree;

public class Tree {

    public static void display(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        display(root.left);
        display(root.right);
    }

    public static int sum(Node root) {
        if (root == null)
            return 0;
        return root.val + sum(root.right) + sum(root.left);
    }

    public static int levels(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    public static int size(Node root) {
        if (root == null)
            return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public static int max(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int max = root.val;
        int x = Math.max(max(root.left), max(root.right));
        return Math.max(max, x);
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(41);
        Node c = new Node(3);
        Node d = new Node(2);
        Node e = new Node(6);
        Node f = new Node(5);
        Node g = new Node(10);
        Node h = new Node(20);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        c.left = g;
        e.right = h;

        display(a);
        System.out.println();
        System.out.println(sum(a));
        System.out.println(max(a));
        System.out.println(size(a));
        System.out.println(levels(a));

    }
}
