package BinaryTree.PathSum;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.Node;

public class paths {
    public List<String> binaryTreePaths(Node root) {
        List<String> sl = new ArrayList<>();

        path(root, "", sl);
        return sl;

    }

    public void path(Node root, String s, List<String> sl) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            s += root.val;
            sl.add(s);
            return;
        }
        path(root.left, s + root.val + "->", sl);
        path(root.right, s + root.val + "->", sl);

    }
}
