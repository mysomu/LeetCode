# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        ans = []
        if root is None:
            return []
        q = deque([root,None])
        while q:
            curr = q.popleft()
            if curr is None:
                res.append(ans)
                ans = []
                if not q:
                    break
                else: 
                    q.append(None)
            else:
                ans.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return res
