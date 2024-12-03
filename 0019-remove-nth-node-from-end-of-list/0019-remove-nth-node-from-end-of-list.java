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
        ListNode curr = new ListNode(0);
        curr.next=head;
        ListNode first = curr;
        ListNode second = curr;
        // Move first n+1 step
        for(int i=0; i<=n; i++){
            first = first.next;
        }
        while(first!=null){
            first = first.next;
            second = second.next;
        }
        // remove the nth node from the end
        second.next = second.next.next;

        return curr.next;
    }
}