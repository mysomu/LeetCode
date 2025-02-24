# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # Helper function to perform DFS traversal
        def bst(root, min_val=float("-inf"), max_val=float("inf")):
            # Base case: If the current node is None, return True
            if root == None:
                return True

            # Check if the current node's value is within the valid range
            if not (min_val < root.val < max_val):
                return False

            # Recursively check the left and right subtrees with updated ranges
            return bst(root.left, min_val, root.val) and bst(
                root.right, root.val, max_val
            )

        # Call the helper function with the root node
        return bst(root)
