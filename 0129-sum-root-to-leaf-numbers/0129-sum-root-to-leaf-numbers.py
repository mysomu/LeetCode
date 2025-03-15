# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def findsum(root,curr_sum):
            if not root:
                return 0
            curr_sum = curr_sum*10 + root.val
            if not root.left and not root.right:
                return curr_sum
            return findsum(root.left,curr_sum) + findsum(root.right, curr_sum)
        val = 0
        res = findsum(root,val)
        return res
        