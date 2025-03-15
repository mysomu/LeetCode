# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.diameter = 0
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.findDepthdfs(root)
        return self.diameter
    def findDepthdfs(self, root):
        if root is None:
            return 0
        left = self.findDepthdfs(root.left) 
        right = self.findDepthdfs(root.right) 

        self.diameter = max(self.diameter, left+right)

        return 1+max(left,right)
        







