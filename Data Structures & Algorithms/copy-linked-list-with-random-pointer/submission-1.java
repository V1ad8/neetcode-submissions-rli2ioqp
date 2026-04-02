/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap();

        if (head == null) {
            return null;
        }

        Node res = new Node(head.val);
        map.put(head, res);

        for (Node curr = head.next; curr != null; curr = curr.next) {
            map.put(curr, new Node(curr.val));
        }

        for (Node curr = head; curr != null; curr = curr.next) {
            Node prev = map.get(curr);
            prev.next = map.get(curr.next);
            prev.random = map.get(curr.random);
        }

        return res;
    }
}
