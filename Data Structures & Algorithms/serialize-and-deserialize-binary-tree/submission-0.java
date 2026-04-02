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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList();
        Queue<TreeNode> q = new LinkedList();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            list.add(node == null ? null : node.val);

            if (node != null) {
                q.add(node.left);
                q.add(node.right);
            }
        }

        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> q = new LinkedList();
        String[] tokens = data.substring(1, data.length() - 1).split(", ");

        if (tokens[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        q.add(root);
        int idx = 1;

        for (var str : tokens) {
            if (q.isEmpty()) {
                break;
            }

            TreeNode node = q.poll();

            if (tokens[idx].equals("null")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(tokens[idx]));
                q.add(node.left);
            }
            idx ++;

            if (tokens[idx].equals("null")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(tokens[idx]));
                q.add(node.right);
            }
            idx ++;
        }

        return root;
    }
}
