package BinaryTree.PathSum;

import BinaryTree.Node;

public class pathSum {
    public boolean hasPathSum(Node root, int targetSum) {

        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            if (root.val == targetSum)
                return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
