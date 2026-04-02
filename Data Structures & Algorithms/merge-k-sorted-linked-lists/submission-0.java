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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode prev = res;

        while (list1 != null || list2 != null) {
            if (list1 != null && (list2 == null || list1.val <= list2.val)) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }

            prev = prev.next;
        }

        return res.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        for (int i = 1; i < lists.length; i ++) {
            lists[i] = mergeTwoLists(lists[i - 1], lists[i]);
        }

        return lists[lists.length - 1];
    }
}
