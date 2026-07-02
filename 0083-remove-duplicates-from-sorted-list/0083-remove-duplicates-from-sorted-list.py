# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        curr = head
        net = curr.next
        while curr and net:
            if curr.val==net.val:
                curr.next = net.next
                net = curr.next
            else:
                curr = curr.next
                net = curr.next
        return head