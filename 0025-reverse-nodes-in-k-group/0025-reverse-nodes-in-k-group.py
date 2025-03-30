# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        count, temp = 0, head
        
        # Check if there are at least k nodes to reverse
        while temp and count < k:
            temp = temp.next
            count += 1
        
        if count < k:
            return head  # Not enough nodes to reverse, return head as is
        
        # Reverse k nodes
        new_head = self.reverse(head, temp)
        
        # Recursively reverse the next part
        head.next = self.reverseKGroup(temp, k)
        
        return new_head

    def reverse(self, start: ListNode, end: ListNode) -> ListNode:
        prev, curr = None, start
        while curr != end:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
        return prev