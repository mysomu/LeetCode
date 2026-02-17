# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        self.finalans = 0
        res = 0
        self.findSum(root,res)
        return self.finalans
    def findSum(self,root,res):
        if not root:
            return
        res = res*10+root.val
        if not root.left and not root.right:
            self.finalans += res
            return
        self.findSum(root.left, res)
        self.findSum(root.right, res)
        