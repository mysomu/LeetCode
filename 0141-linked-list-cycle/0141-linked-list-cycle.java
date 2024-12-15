/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        HashSet<ListNode> visit = new HashSet<>();
        ListNode curr = head;
        while(curr!=null){
            if(visit.contains(curr)){
                return true;
            }
            visit.add(curr);
            curr = curr.next;
        }
        return false;        
    }
}