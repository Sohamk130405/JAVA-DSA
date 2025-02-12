package BinaryTree.PathSum;

import BinaryTree.Node;

class Maximum {

    public int maxPathSum(Node root) {
        int[] ans = { Integer.MIN_VALUE };
        lineSum(root, ans);
        return ans[0];
    }

    public int lineSum(Node root, int[] ans) {
        if (root == null)
            return 0;
        int leftLineSum = lineSum(root.left, ans);
        int rightLineSum = lineSum(root.right, ans);
        int pathSum = root.val;
        if (leftLineSum > 0)
            pathSum += leftLineSum;
        if (rightLineSum > 0)
            pathSum += rightLineSum;
        ans[0] = Math.max(pathSum, ans[0]);
        return root.val + Math.max(Math.max(leftLineSum, rightLineSum), 0);
    }
}