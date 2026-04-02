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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        Queue<Pair<TreeNode, Integer>> q = new LinkedList();

        q.add(new Pair(root, 0));
        int depth = 0;
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());

        while (!q.isEmpty()) {
            var pair = q.poll();

            TreeNode p = pair.getKey();
            int localDepth = pair.getValue();

            while (localDepth > depth) {
                res.add(new ArrayList());
                depth ++;
            }

            res.get(depth).add(p.val);

            if (p.left != null) {
                q.add(new Pair(p.left, depth + 1));
            }

            if (p.right != null) {
                q.add(new Pair(p.right, depth + 1));
            }
        }

        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> lists = levelOrder(root);

        List<Integer> res = new ArrayList();
        for (var list : lists) {
            res.add(list.get(list.size() - 1));
        }

        return res;
    }
}
