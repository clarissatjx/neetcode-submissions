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
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = null;
        ListNode other = null;

        if (list1.val > list2.val) {
            head = list2;
            other = list1;
        } else {
            head = list1;
            other = list2;
        }

        ListNode pointer = head;

        while (other != null) {
            if (pointer.next == null) {
                pointer.next = other;
                return head;
            }
            if (pointer.next.val > other.val) {
                ListNode temp = pointer.next;
                pointer.next = other;
                pointer = pointer.next;
                other = temp;
            } else {
                pointer = pointer.next;
            }
        }

        return head;
        
    }
}