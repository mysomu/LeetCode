# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        newNode = TreeNode(val)
        if root is None:
            return newNode

        curr = root
        while curr != None:
            # left
            if val < curr.val:
                if curr.left != None:
                    curr = curr.left
                else:
                    curr.left = newNode
                    break
            else:
                # right
                if curr.right != None:
                    curr = curr.right
                else:
                    curr.right = newNode
                    break
        return root
