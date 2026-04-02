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

    public int explore(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        int ret = explore(root.left, k);
        if (ret != -1) {
            return ret;
        }

        if (place == -1 && root.left == null) {
            place = 0;
        }

        if (place != -1) {
            place ++;
            if (k == place) {
                return root.val;
            }
        }

        ret = explore(root.right, k);
        if (ret != -1) {
            return ret;
        }

        return -1;
    }

    public int kthSmallest(TreeNode root, int k) {
        return explore(root, k);
    }
}
