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
    int place = -1;
    int res = -1;

    public void explore(TreeNode root, int k) {
        if (root == null || res != -1) {
            return;
        }

        explore(root.left, k);

        if (place == -1 && root.left == null) {
            place = 0;
        }

        if (place != -1) {
            place ++;
            if (k == place) {
                res = root.val;
                return;
            }
        }

        explore(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        explore(root, k);
        return res;
    }
}
