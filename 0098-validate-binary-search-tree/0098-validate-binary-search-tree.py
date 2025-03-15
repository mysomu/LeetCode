# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inorder(node: Optional[TreeNode]) -> None:
            nonlocal prev, isValid
            if not isValid or not node:
                return

            inorder(node.left)

            if prev is not None and prev >= node.val:
                isValid = False
                return
            
            prev = node.val
            
            inorder(node.right)
        
        prev = None  
        isValid = True  
        inorder(root)
        return isValid
