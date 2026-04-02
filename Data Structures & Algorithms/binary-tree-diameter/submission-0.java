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
    public Pair<Integer, Integer> depth(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair <Integer, Integer> left, right;

        left = depth(root.left);
        right = depth(root.right);

        int local = left.getKey() + right.getKey() + 1;
        return new Pair(Math.max(left.getKey(), right.getKey()) + 1,
                        Math.max(Math.max(left.getValue(), right.getValue()), local));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Pair<Integer, Integer> res = depth(root);

        return res.getValue() - 1;
    }
}
