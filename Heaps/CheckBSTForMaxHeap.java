

class Node {
    public int val;
    public Node left, right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class CheckBSTForMaxHeap {
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(8);
        Node c = new Node(7);
        Node d = new Node(6);
        Node e = new Node(4);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(isMaxHeap(a));
    }

    public static boolean isMaxHeap(Node root) {
        return (isSatisfyHOP(root) && isCBT(root, 0, size(root)));

    }

    private static boolean isCBT(Node root, int idx, Integer n) {
        if (root == null)
            return true;
        if (idx >= n)
            return false;
        return isCBT(root.left, 2 * idx + 1, n) && isCBT(root.right, 2 * idx + 2, n);

    }

    private static int size(Node root) {
        if (root == null)
            return 0;
        return 1 + size(root.left) + size(root.right);
    }

    private static boolean isSatisfyHOP(Node root) {
        if (root == null)
            return true;
        if (root.left != null && root.val < root.left.val)
            return false;
        if (root.right != null && root.val < root.right.val)
            return false;

        return isSatisfyHOP(root.left) && isSatisfyHOP(root.right);
    }
}
