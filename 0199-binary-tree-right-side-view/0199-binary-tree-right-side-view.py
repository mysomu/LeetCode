# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self.rightView(root, 0, result)
        return result

    def rightView(self, root, level, result):
        if root is None:
           return
        if level == len(result):
            result.append(root.val)
        self.rightView(root.right, level+1,result)
        self.rightView(root.left, level+1,result)