# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        values = []
        self.inorder(root, values)
        return values[k-1]
    def inorder(self, root, values):
        if root is None:
            return
        self.inorder(root.left,values)
        values.append(root.val)
        self.inorder(root.right,values)