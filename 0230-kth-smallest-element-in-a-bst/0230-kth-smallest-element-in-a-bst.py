# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        res = [k,None]
        self.inorder(root,res)
        return res[1]

    def inorder(self,root,res):
        if not root:
            return
        self.inorder(root.left,res)
        res[0]-= 1
        if res[0] == 0 :
            res[1]=root.val
            return 
        self.inorder(root.right,res)
