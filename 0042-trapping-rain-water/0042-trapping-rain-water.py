class Solution:
    def trap(self, height: list[int]) -> int:
        left, right = 0, len(height) - 1
        left_max, right_max = height[0], height[-1]
        water = 0
        
        while left < right:
            if left_max < right_max:
                left += 1
                if left_max < height[left]:
                    left_max = height[left]
                else:
                    water += left_max - height[left]
            else:
                right -= 1
                if right_max < height[right]:
                    right_max = height[right]
                else:
                    water += right_max - height[right]
        
        return water
