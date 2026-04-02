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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode prev = res;

        int carry = 0;
        int val;
        while (l1 != null && l2 != null) {
            val = l1.val + l2.val + carry;
            prev.next = new ListNode(val % 10);
            prev = prev.next;

            carry = (val) / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            val = l1.val + carry;
            prev.next = new ListNode(val % 10);
            prev = prev.next;
            
            carry = (val) / 10;

            l1 = l1.next;
        }

        while (l2 != null) {
            val = l2.val + carry;
            prev.next = new ListNode(val % 10);
            prev = prev.next;
            
            carry = (val) / 10;

            l2 = l2.next;
        }

        if (carry != 0) {
            prev.next = new ListNode(carry);
        }

        return res.next;
    }
}
