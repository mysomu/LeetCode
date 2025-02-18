# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next:
            return
        
        # Find the middle node
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        # Reverse the second half
        head2 = self.reverse(slow.next)
        slow.next = None  # Split the list
        
        # Merge two halves
        while head and head2:
            tmp1, tmp2 = head.next, head2.next
            head.next, head2.next = head2, tmp1
            head, head2 = tmp1, tmp2
    
    def reverse(self, node: ListNode) -> ListNode:
        prev, curr = None, node
        while curr:
            nxt = curr.next
            curr.next = prev
            prev, curr = curr, nxt
        return prev
        