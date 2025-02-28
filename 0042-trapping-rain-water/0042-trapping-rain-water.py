from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        length = len(height)
        res = 0
        left_max = [0] * length
        right_max = [0] * length

        # Compute left max height for each index
        left_max[0] = height[0]
        for i in range(1, length):
            left_max[i] = max(left_max[i - 1], height[i])

        # Compute right max height for each index
        right_max[length - 1] = height[length - 1]
        for i in range(length - 2, -1, -1):
            right_max[i] = max(right_max[i + 1], height[i])

        # Calculate trapped water
        for i in range(length):
            res += min(left_max[i], right_max[i]) - height[i]

        return res
