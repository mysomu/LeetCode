# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        res = []
        self.inorder(root,res,k)
        return res[-1]

    def inorder(self,root,res,k):
        if not root:
            return
        self.inorder(root.left,res,k)
        if len(res) == k:
            return
        res.append(root.val)
        self.inorder(root.right,res,k)
