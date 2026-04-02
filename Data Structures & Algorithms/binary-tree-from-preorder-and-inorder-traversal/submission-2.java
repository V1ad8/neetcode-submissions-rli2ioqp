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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int end = 0;
        for (; end < inorder.length && inorder[end] != preorder[0]; end ++);
        if (end == inorder.length) {
            return null;
        }

        int[] arr1 = Arrays.copyOfRange(inorder, 0, end);
        int[] arr2 = Arrays.copyOfRange(preorder, 1, 1 + end);
        int[] arr3 = Arrays.copyOfRange(inorder, end + 1, inorder.length);
        int[] arr4 = Arrays.copyOfRange(preorder, 1 + end, preorder.length);

        return new TreeNode(preorder[0], buildTree(arr2, arr1), buildTree(arr4, arr3));
    }
}
