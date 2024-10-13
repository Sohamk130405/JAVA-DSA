package BinaryTree.Traversal;

import BinaryTree.Node;

public class diameter {
    public int diameterOfBinaryTree(Node root) {
        if (root == null)
            return 0;
        int d = levels(root.left) + levels(root.right);
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        return Math.max(d, Math.max(rd, ld));
    }

    public int levels(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }
}
