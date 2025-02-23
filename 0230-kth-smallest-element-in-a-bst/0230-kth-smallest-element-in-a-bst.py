# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = [0]  
        result = [None]
        self.inorder(root, k, count, result)
        return result[0]

    def inorder(self, node: Optional[TreeNode], k: int, count: list, result: list):
        if node is None or result[0] is not None:
            return

        self.inorder(node.left, k, count, result)
        
        count[0] += 1
        if count[0] == k:
            result[0] = node.val
            return
        
        self.inorder(node.right, k, count, result)    