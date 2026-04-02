/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneNode(Node node, Map<Node, Node> translate) {
        if (node == null) {
            return null;
        }

        if (translate.containsKey(node)) {
            return translate.get(node);
        }

        Node cpy = new Node(node.val);
        translate.put(node, cpy);

        for (var neigh : node.neighbors) {
            cpy.neighbors.add(cloneNode(neigh, translate));
        }

        return cpy;
    }

    public Node cloneGraph(Node node) {
        return cloneNode(node, new HashMap());
    }
}