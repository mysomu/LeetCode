# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        ans = self.inOrder(root, k)
        return ans.val

    def inOrder(self, root, k):
        if root is None:
            return None        
        # Traverse left
        left = self.inOrder(root.left, k)
        if left is not None:
            return left        
        # Visit current node
        self.count += 1
        if self.count == k:
            return root        
        # Traverse right
        return self.inOrder(root.right, k)
