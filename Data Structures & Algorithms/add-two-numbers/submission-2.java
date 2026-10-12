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
        int carry = 0;

        ListNode res = new ListNode(0);
        ListNode pointer = res;
        ListNode dummy = new ListNode(0);

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = dummy;
            }
            if (l2 == null) {
                l2 = dummy;
            }
            int total = l1.val + l2.val + carry;
            if (total >= 10) {
                carry = 1;
                total -= 10;
            } else {
                carry = 0;
            }
            pointer.next = new ListNode(total);
            pointer = pointer.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (carry == 1) {
            pointer.next = new ListNode(1);
        }

        return res.next;
        
    }
}
