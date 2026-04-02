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
    public int max(int a, int b) {
        return a > b ? a : b;
    }

    // path 1 way / max so far
    public Pair<Integer, Integer> path(TreeNode root) {
        if (root == null) {
            return new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }


        Pair<Integer, Integer> left = path(root.left);
        Pair<Integer, Integer> right = path(root.right);

        // Go trough the root
        int trough = root.val + max(left.getKey(), 0) + max(right.getKey(), 0);

        // Pick a child
        int path1Way = max(max(left.getKey(), right.getKey()), 0) + root.val;

        return new Pair(path1Way, max(trough, max(left.getValue(), right.getValue())));
    }

    public int maxPathSum(TreeNode root) {
        return path(root).getValue();
    }
}
