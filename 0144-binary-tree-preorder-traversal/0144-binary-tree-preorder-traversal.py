# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
       result = []
       self.preOrder(root, result)
       return result

    def preOrder(self, root, result):
        if not root:
            return
        result.append(root.val)
        self.preOrder(root.left,result)
        self.preOrder(root.right,result)
