# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = None

    def flatten(self, root: TreeNode) -> None:
        if not root:
            return

        # Process right subtree first
        self.flatten(root.right)

        # Process left subtree
        self.flatten(root.left)

        # Set the current node's right to prev and left to null
        root.right = self.prev
        root.left = None

        # Update prev to current node
        self.prev = root
