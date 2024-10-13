package BinaryTree;

public class constructBinaryTree {
    public Node helperPreIn(int[] pre, int[] in, int pl, int ph, int il, int ih) {
        if (pl > ph || il > ih)
            return null;
        Node root = new Node(pre[pl]);
        int r = 0;
        while (in[r] != pre[pl])
            r++;
        int ls = r - il;
        root.left = helperPreIn(pre, in, pl + 1, pl + ls, il, r - 1);
        root.right = helperPreIn(pre, in, pl + ls + 1, ph, r + 1, ih);
        return root;
    }

    public Node buildTreePreIn(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helperPreIn(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public Node helperInPo(int[] in, int[] po, int il, int ih, int pl, int ph) {
        if (pl > ph || il > ih)
            return null;
        Node root = new Node(po[ph]);

        int r = il;
        while (in[r] != po[ph])
            r++;
        int leftTreeSize = r - il;
        root.left = helperInPo(in, po, il, r - 1, pl, pl + leftTreeSize - 1);
        root.right = helperInPo(in, po, r + 1, ih, pl + leftTreeSize, ph - 1);

        return root;
    }

    public Node buildTreePoIn(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helperInPo(inorder, postorder, 0, n - 1, 0, n - 1);
    }
}
