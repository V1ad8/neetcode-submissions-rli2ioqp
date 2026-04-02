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
    public int count(TreeNode root, int max) {
        int newMax = Math.max(root.val, max);
        int res = root.val >= max ? 1 : 0;

        if (root.left != null) {
            res += count(root.left, newMax);
        }

        if (root.right != null) {
            res += count(root.right, newMax);
        }

        return res;
    }

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return count(root, root.val);
    }
}
