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
    public void print(ListNode head) {
        System.out.print("[");

        for (ListNode curr = head; curr != null; curr = curr.next) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(",");
            }
        }

        System.out.println("]");
    }

    public ListNode reverseList(ListNode head) {
        ListNode res = null;

        while (head != null) {
            res = new ListNode(head.val, res);
            head = head.next;
        }

        return res;
    }

    public void reorderList(ListNode head) {
        int n = 0;

        ListNode curr;
        for (curr = head; curr != null; curr = curr.next, n ++);

        int i = 0;
        for (curr = head; i < (n - 1) / 2; curr = curr.next, i ++);

        ListNode reverse = reverseList(curr.next);
        curr.next = null;

        ListNode res = new ListNode();
        ListNode prev = res;

        for (i = 0; i < n / 2; i ++) {
            prev.next = head;
            head = head.next;
            prev = prev.next;

            prev.next = reverse;
            reverse = reverse.next;
            prev = prev.next;
        }

        if (n % 2 == 1) {
            prev.next = head;
        }

        head = res.next;
    }
}
