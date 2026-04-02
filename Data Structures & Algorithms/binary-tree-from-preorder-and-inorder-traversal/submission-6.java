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
    public TreeNode build(int[] preorder, int startP, int endP, int[] inorder, int startI, int endI) {
        if (endP - startP <= 0 || endI - startI <= 0) {
            return null;
        }

        int end = startI;
        for (; end < endI && inorder[end] != preorder[startP]; end ++);
        if (end == endI) {
            return null;
        }

        int midP = startP + 1 + end - startI;

        return new TreeNode(preorder[startP],
                            build(preorder, startP + 1, midP, inorder, startI, end),
                            build(preorder, midP, endP, inorder, end + 1, endI));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
}
