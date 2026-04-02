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
        ListNode curr = head, next;
        ListNode end;

        ListNode res = new ListNode();
        ListNode prev = res;

        int n;
        for (n = 0, curr = head; curr != null; n ++, curr = curr.next);

        System.out.println(n);

        curr = head;
        for (int j = k; j <= n; j += k) {
            end = curr;
            for (int i = 0; i < k - 1 && end.next != null; i ++, end = end.next);

            System.out.println(curr.val + " - " + end.val);

            next = end.next;
            end.next = null;

            ListNode reversed = reverseList(curr);

            ListNode it;
            for (it = reversed; it.next != null; it = it.next);

            prev.next = reversed;
            it.next = next;

            prev = it;
            curr = next;
        }

        return res.next;
    }
}
