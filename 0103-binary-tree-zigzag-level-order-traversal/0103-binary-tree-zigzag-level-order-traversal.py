# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        ans = []
        q = deque([root])
        left_to_right = True

        while q:
            level_size = len(q)
            subans = deque()

            for _ in range(level_size):
                node = q.popleft()

                if left_to_right:
                    subans.append(node.val)
                else:
                    subans.appendleft(node.val)

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)

            ans.append(list(subans))
            left_to_right = not left_to_right

        return ans
