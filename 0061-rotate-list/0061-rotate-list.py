# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next or k == 0:
            return head

        # Step 1: find length and tail
        tail = head
        length = 1
        while tail.next:
            tail = tail.next
            length += 1

        # Step 2: optimize k
        k = k % length
        if k == 0:
            return head

        # Step 3: make list circular
        tail.next = head

        # Step 4: find new tail
        rotate = length - k
        curr = head
        for _ in range(1,rotate):
            curr = curr.next

        # Step 5: break the circle
        newHead = curr.next
        curr.next = None

        return newHead
