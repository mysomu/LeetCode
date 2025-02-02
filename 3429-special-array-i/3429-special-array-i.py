class Solution:
    def isArraySpecial(self, nums: list[int]) -> bool:
        for i in range(len(nums) - 1):
            if (nums[i] + nums[i + 1]) % 2 == 0:
                return False  # Break early if any consecutive pair has an even sum
        return True  # Return True if all pairs have an odd sum