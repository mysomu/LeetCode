# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.ans = 0
        
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.findHeightdfs(root)
        return self.ans

    def findHeightdfs(self, node):
        if node is None:
            return 0
        left = self.findHeightdfs(node.left)
        right = self.findHeightdfs(node.right)

        self.ans = max(self.ans, left+right)

        return 1+max(left,right)
    
        