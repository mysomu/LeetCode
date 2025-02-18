# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        pointer = dummy
        
        while pointer:
            node = pointer
            for i in range(k):
                if not node.next:
                    return dummy.next
                node = node.next
            
            prev, curr = None, pointer.next
            for i in range(k):
                next_node = curr.next
                curr.next = prev
                prev = curr
                curr = next_node
            
            tail = pointer.next
            tail.next = curr
            pointer.next = prev
            pointer = tail
        
        return dummy.next

    