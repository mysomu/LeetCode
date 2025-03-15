# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def validate(node, prev=float('-inf'), next=float('inf')) -> bool:
            if not node:
                return True
            if not (prev < node.val < next):
                return False
            return validate(node.left, prev, node.val) and validate(node.right, node.val, next)

        return validate(root)
      