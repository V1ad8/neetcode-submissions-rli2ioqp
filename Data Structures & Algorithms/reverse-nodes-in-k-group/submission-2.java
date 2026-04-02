/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode res = null;

        while (head != null) {
            res = new ListNode(head.val, res);
            head = head.next;
        }

        return res;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr, next;
        ListNode end;

        ListNode it, reversed;

        ListNode res = new ListNode();
        ListNode prev = res;

        int i, j, n;
        for (n = 0, curr = head; curr != null; n ++, curr = curr.next);

        curr = head;
        for (j = k; j <= n; j += k) {
            end = curr;
            for (i = 0; i < k - 1 && end.next != null; i ++, end = end.next);

            next = end.next;
            end.next = null;

            reversed = reverseList(curr);

            for (it = reversed; it.next != null; it = it.next);

            prev.next = reversed;
            it.next = next;

            prev = it;
            curr = next;
        }

        return res.next;
    }
}
