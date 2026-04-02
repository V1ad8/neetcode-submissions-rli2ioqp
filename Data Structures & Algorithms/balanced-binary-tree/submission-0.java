/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public Pair<Integer, Boolean> depth(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }

        Pair<Integer, Boolean> left = depth(root.left);
        Pair<Integer, Boolean> right = depth(root.right);

        return new Pair(Math.max(left.getKey(), right.getKey()) + 1,
                        left.getValue() && right.getValue()
                            && (Math.abs(left.getKey() - right.getKey()) <= 1));
    }

    public boolean isBalanced(TreeNode root) {
        return depth(root).getValue();
    }
}
