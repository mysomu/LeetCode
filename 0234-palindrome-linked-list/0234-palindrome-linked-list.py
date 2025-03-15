# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        curr_node = head
        stack = []
        while curr_node is not None:
            stack.append(curr_node.val) # 1->2->2->1
            curr_node = curr_node.next
        while head is not None:
            c = stack.pop()
            if c != head.val:
                return False
            head = head.next
        return True
    


        