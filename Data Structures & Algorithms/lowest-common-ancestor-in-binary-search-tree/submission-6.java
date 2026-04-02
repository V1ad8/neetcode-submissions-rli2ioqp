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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return q.val == p.val;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        
        return isSameTree(root, subRoot)
            || (root.left != null && isSubtree(root.left, subRoot))
            || (root.right != null && isSubtree(root.right, subRoot));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (isSubtree(root.left, p) && isSubtree(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (isSubtree(root.right, p) && isSubtree(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
