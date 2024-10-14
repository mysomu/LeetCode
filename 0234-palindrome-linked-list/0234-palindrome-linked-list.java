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
    public boolean isPalindrome(ListNode head) {
        ListNode h1 = head;
        int count = 0;
        while (h1 != null) { // counting nodes
            h1 = h1.next;
            count++;
        }
        ListNode left = null;
        ListNode right = null;
        ListNode prev = null;
        // splitting by the middle and reversing first half
        for (int i = 1; i <= count / 2; i++) {
            right = head.next;
            head.next = prev;
            prev = head;
            left = head;
            head = right;
            if (i == count / 2 && count % 2 == 1) { // handle right half start for odd node count
                right = right.next;
            }
        }

        // comparing to half
        while (left != null) {
            if (left.val != right.val) { // if value not equal -> return false
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true; // return true if all values was equal
    }
}