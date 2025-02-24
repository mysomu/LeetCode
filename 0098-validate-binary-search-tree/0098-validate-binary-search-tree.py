# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = float('-inf')
        self.isValid = True

    def inorder(self, root: Optional[TreeNode]) -> None:
        if not self.isValid or not root:
            return

        self.inorder(root.left)

        if self.prev >= root.val:
            self.isValid = False
            return
        self.prev = root.val

        self.inorder(root.right)

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = float('-inf')  # Reset prev for each call
        self.isValid = True  # Reset isValid for each call
        self.inorder(root)
        return self.isValid