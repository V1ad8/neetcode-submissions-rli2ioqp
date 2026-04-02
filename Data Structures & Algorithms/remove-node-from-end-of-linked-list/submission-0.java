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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 0;

        ListNode curr;
        for (curr = head; curr != null; curr = curr.next, sz ++);
        
        if (n == sz) {
            return head.next;
        }

        int i = 0;
        for (curr = head; i < sz - n - 1 && curr != null; curr = curr.next, i ++);
        curr.next = curr.next.next;

        return head;
    }
}
